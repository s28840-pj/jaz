package com.rabulinski.zaj2.orders;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<OrderResponse> getOrders() {
        return orderRepository.findAll().stream()
                .map(order -> modelMapper.map(order, OrderResponse.class))
                .collect(Collectors.toList());
    }

    public OrderResponse getOrder(Integer id) {
        PizzaOrder order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        return modelMapper.map(order, OrderResponse.class);
    }

    public OrderResponse createOrder(OrderCreateRequest request) {
        PizzaOrder order = modelMapper.map(request, PizzaOrder.class);
        PizzaOrder savedOrder = orderRepository.save(order);
        return modelMapper.map(savedOrder, OrderResponse.class);
    }

    public OrderResponse updateOrder(Integer id, OrderCreateRequest request) {
        PizzaOrder order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        modelMapper.map(request, order);
        PizzaOrder updatedOrder = orderRepository.save(order);
        return modelMapper.map(updatedOrder, OrderResponse.class);
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

}