package com.reactiveprogramming.webflux.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactiveprogramming.webflux.handler.CustomerHandler;
import com.reactiveprogramming.webflux.handler.CustomerStreamHandler;

@Configuration
public class RouterConfig {
    @Autowired
    private CustomerHandler customerHandler;

    @Autowired
    private CustomerStreamHandler customerStreamHandler;

    // making use of the RouterFunction to route the request to the appropriate
    // handler
    // used functional endpoints to route the request to the appropriate handler
    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .GET("/router/customer", customerHandler::loadCustomers)
                .GET("/router/customer/stream", customerStreamHandler::getCustomers)
                .GET("/router/customer/{input}", customerHandler::findCustomer)
                .POST("/router/customer/save", customerHandler::saveCustomer)
                .build();
    }
}
