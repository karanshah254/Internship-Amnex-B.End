package com.reactiveprogramming.webflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactiveprogramming.webflux.dao.CustomerDAO;
import com.reactiveprogramming.webflux.dto.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {
    @Autowired
    private CustomerDAO customerDAO;

    public Mono<ServerResponse> loadCustomers(ServerRequest request) {
        Flux<Customer> list = customerDAO.getCustomerList();
        return ServerResponse.ok().body(list, Customer.class);
    }

    public Mono<ServerResponse> findCustomer(ServerRequest request) {
        int customerId = Integer.valueOf(request.pathVariable("input"));
        // customerDAO.getCustomerList().filter(c -> c.getId() ==
        // customerId).take(1).single();
        Mono<Customer> singleCustomer = customerDAO.getCustomerList().filter(c -> c.getId() == customerId).next();
        return ServerResponse.ok().body(singleCustomer, Customer.class);
    }

    public Mono<ServerResponse> saveCustomer(ServerRequest request) {
        Mono<Customer> saveCustomer = request.bodyToMono(Customer.class);
        Mono<String> saveResponse = saveCustomer.map(dto -> dto.getId() + ":" + dto.getName());
        return ServerResponse.ok().body(saveResponse, String.class);
    }
}
