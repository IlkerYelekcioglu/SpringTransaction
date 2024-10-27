package com.example.springtransaction.controller;

import com.example.springtransaction.service.CustomerOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers-orders")
@RequiredArgsConstructor
public class CustomerOrderController {
private final CustomerOrderService customerOrderService;

@PostMapping("/createCustomerOrder")
  public  String createCustomerOrder(@RequestParam String customerName,@RequestParam String productName){
  try{
    customerOrderService.saveCustomerAndOrder(customerName,productName);
    return "Müşteri ve Sipariş başarıyla kaydedildi";
  }catch (Exception e){
    return "İşlem başarısız oldu" + e.getMessage();
  }
}
}
