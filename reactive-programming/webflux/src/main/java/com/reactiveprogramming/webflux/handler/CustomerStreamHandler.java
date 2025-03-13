package com.reactiveprogramming.webflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactiveprogramming.webflux.dao.CustomerDAO;
import com.reactiveprogramming.webflux.dto.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {
    @Autowired
    private CustomerDAO customerDAO;

    public Mono<ServerResponse> getCustomers(ServerRequest request) {
        Flux<Customer> customerStream = customerDAO.getCustomerStream();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM) // send as an event and response will give the data in real-time
                .body(customerStream, Customer.class);
    }
}
