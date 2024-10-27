package com.example.springtransaction.service;

import com.example.springtransaction.model.Customer;
import com.example.springtransaction.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService {
   private final CustomerRepository customerRepository;

   public Customer saveCustomer(String customerName) {
     Customer customer = Customer.builder()
         .name(customerName)
         .build();
     if(customerName.equals("error")) throw new RuntimeException("Bir hata oluştu");
      return customerRepository.save(customer);
   }
}
