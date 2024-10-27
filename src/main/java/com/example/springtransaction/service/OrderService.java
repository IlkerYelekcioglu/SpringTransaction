package com.example.springtransaction.service;

import com.example.springtransaction.model.Order;
import com.example.springtransaction.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
private final OrderRepository orderRepository;
public Order saveOrder(String productName,Long customerId){
      Order order = Order.builder()
          .productName(productName)
          .customerId(customerId)
          .build();
      if(productName.equals("error")) throw new RuntimeException("Bir hata oluştu");
      return orderRepository.save(order);
   }
}
