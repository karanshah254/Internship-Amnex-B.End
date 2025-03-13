package com.reactiveprogramming.webflux.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.reactiveprogramming.webflux.dto.Customer;

import reactor.core.publisher.Flux;

@Component
public class CustomerDAO {
    private static void sleepTime(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getCustomer() {
        return IntStream.rangeClosed(1, 10)
                .peek(CustomerDAO::sleepTime)
                .peek(i -> System.out.println("count" + i))
                .mapToObj(i -> new Customer(i, "Customer" + i))
                .collect(Collectors.toList());

    }

    public Flux<Customer> getCustomerStream() {
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("count in stream" + i))
                .map(i -> new Customer(i, "Customer" + i));

    }

    public Flux<Customer> getCustomerList() {
        return Flux.range(1, 50)
                .doOnNext(i -> System.out.println("count in stream" + i))
                .map(i -> new Customer(i, "Customer" + i));

    }
}
