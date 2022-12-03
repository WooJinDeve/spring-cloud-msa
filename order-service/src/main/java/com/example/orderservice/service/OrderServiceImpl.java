package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.entity.OrderEntity;
import com.example.orderservice.entity.OrderRepository;
import com.example.orderservice.vo.ResponseOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;


    @Override
    @Transactional
    public ResponseOrder createOrder(OrderDto orderDto) {
        OrderEntity orderEntity = initNewOrder(orderDto);

        OrderEntity saveOrder = orderRepository.save(orderEntity);

        return ResponseOrder.of(saveOrder);
    }

    private OrderEntity initNewOrder(OrderDto orderDto){
        String orderId = UUID.randomUUID().toString();
        Integer totalPrice = orderDto.getQuantity() * orderDto.getUnitPrice();

        return OrderEntity.builder()
                .orderId(orderId)
                .productId(orderDto.getProductId())
                .userId(orderDto.getUserId())
                .quantity(orderDto.getQuantity())
                .unitPrice(orderDto.getUnitPrice())
                .totalPrice(totalPrice)
                .build();
    }


    @Override
    public ResponseOrder getByOrderId(String orderId) {
        OrderEntity order = orderRepository.findByOrderId(orderId)
                .orElseThrow(NoSuchElementException::new);

        return ResponseOrder.of(order);
    }

    @Override
    public List<ResponseOrder> getAllByUserId(String userId) {
        return orderRepository.findByUserId(userId).stream()
                .map(ResponseOrder::of)
                .collect(Collectors.toList());
    }
}
