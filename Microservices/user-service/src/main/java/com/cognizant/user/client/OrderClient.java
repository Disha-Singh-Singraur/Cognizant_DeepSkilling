package com.cognizant.user.client;

import com.cognizant.user.model.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "order-service")
public interface OrderClient {

    @GetMapping("/orders/user/{userId}")
    List<OrderDto> getOrdersByUserId(@PathVariable("userId") Long userId);
}
