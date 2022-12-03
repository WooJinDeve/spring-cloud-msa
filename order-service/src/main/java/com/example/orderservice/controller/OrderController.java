package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.vo.RequestOrder;
import com.example.orderservice.vo.ResponseOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order-service")
public class OrderController {

    private final Environment env;

    private final OrderService orderService;


    @GetMapping("/health_check")
    public String status() {
        return String.format("It's Working in Order Service On PORT %s",
                env.getProperty("local.server.port"));
    }

    @PostMapping("/users/{userId]/orders")
    public ResponseEntity<ResponseOrder> createOrder(@RequestBody RequestOrder requestOrder,
                                                     @PathVariable String userId) {
        OrderDto orderDto = OrderDto.builder()
                .productId(requestOrder.getProductId())
                .quantity(requestOrder.getQuantity())
                .unitPrice(requestOrder.getUnitPrice())
                .userId(userId)
                .build();

        ResponseOrder response = orderService.createOrder(orderDto);

        return ResponseEntity.status(CREATED).body(response);

    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<ResponseOrder> getByOrderId(@PathVariable String orderId){
        ResponseOrder response = orderService.getByOrderId(orderId);

        return ResponseEntity.status(OK).body(response);
    }


    @GetMapping("/users/{userId}/orders")
    public ResponseEntity<List<ResponseOrder>> getOrdersByUserId(@PathVariable String userId) {
        //logic
        List<ResponseOrder> response = orderService.getAllByUserId(userId);

        return ResponseEntity.status(OK).body(response);
    }
}
