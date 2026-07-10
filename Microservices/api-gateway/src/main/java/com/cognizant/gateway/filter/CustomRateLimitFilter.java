package com.cognizant.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CustomRateLimitFilter extends AbstractGatewayFilterFactory<CustomRateLimitFilter.Config> {

    private final ConcurrentHashMap<String, RequestCounter> requestCounts = new ConcurrentHashMap<>();

    public CustomRateLimitFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String clientIp = exchange.getRequest().getRemoteAddress() != null 
                    ? exchange.getRequest().getRemoteAddress().getAddress().getHostAddress() 
                    : "unknown";
            long now = System.currentTimeMillis();
            
            RequestCounter counter = requestCounts.compute(clientIp, (key, val) -> {
                if (val == null || now - val.startTime > 60000) {
                    return new RequestCounter(now, 1);
                } else {
                    val.count.incrementAndGet();
                    return val;
                }
            });

            if (counter.count.get() > config.getLimit()) {
                exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
                return exchange.getResponse().setComplete();
            }
            return chain.filter(exchange);
        };
    }

    public static class Config {
        private int limit = 10; // default requests limit per minute

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }
    }

    private static class RequestCounter {
        final long startTime;
        final AtomicInteger count;

        RequestCounter(long startTime, int initialCount) {
            this.startTime = startTime;
            this.count = new AtomicInteger(initialCount);
        }
    }
}
