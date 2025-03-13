package com.reactiveprogramming.webflux.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactiveprogramming.webflux.dto.Customer;
import com.reactiveprogramming.webflux.service.CustomerService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("all")
    public List<Customer> getAllCustomers() {
        return customerService.loadAll();
    }

    // reactive programming with webflux using Flux API to stream the data to the
    // client in real-time using the MediaType.TEXT_EVENT_STREAM_VALUE
    // The MediaType.TEXT_EVENT_STREAM_VALUE is used to stream the data to the
    // client in real-time.
    // The getAllCustomersStream() method returns the Flux<Customer> object, which
    // is a reactive stream of data.
    @GetMapping(value = "stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomersStream() {
        return customerService.loadAllStreams();
    }
}
