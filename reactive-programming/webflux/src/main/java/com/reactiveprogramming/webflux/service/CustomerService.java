package com.reactiveprogramming.webflux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactiveprogramming.webflux.dao.CustomerDAO;
import com.reactiveprogramming.webflux.dto.Customer;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    public List<Customer> loadAll() {
        long start = System.currentTimeMillis();
        List<Customer> listOfCustomers = customerDAO.getCustomer();
        long end = System.currentTimeMillis();
        System.out.println("Time taken to fetch the data: " + (end - start) + "ms");
        return listOfCustomers;
    }

    public Flux<Customer> loadAllStreams() {
        long start = System.currentTimeMillis();
        Flux<Customer> listOfCustomers = customerDAO.getCustomerStream();
        long end = System.currentTimeMillis();
        System.out.println("Time taken to fetch the data: " + (end - start) + "ms");
        return listOfCustomers;
    }
}
