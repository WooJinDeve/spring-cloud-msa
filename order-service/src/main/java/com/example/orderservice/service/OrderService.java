package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.vo.ResponseOrder;

import java.util.List;

public interface OrderService {

    ResponseOrder createOrder(OrderDto orderDto);
    ResponseOrder getByOrderId(String orderId);
    List<ResponseOrder> getAllByUserId(String userId);
}
