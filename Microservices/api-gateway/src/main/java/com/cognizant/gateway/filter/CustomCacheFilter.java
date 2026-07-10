package com.cognizant.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomCacheFilter extends AbstractGatewayFilterFactory<CustomCacheFilter.Config> {

    public CustomCacheFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            exchange.getResponse().getHeaders().set("Cache-Control", "max-age=" + config.getTtlSeconds());
            return chain.filter(exchange);
        };
    }

    public static class Config {
        private int ttlSeconds = 60;

        public int getTtlSeconds() {
            return ttlSeconds;
        }

        public void setTtlSeconds(int ttlSeconds) {
            this.ttlSeconds = ttlSeconds;
        }
    }
}
