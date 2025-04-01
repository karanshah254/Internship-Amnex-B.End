package com.reactive.programming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;

@SpringBootApplication
public class ReactiveProgrammingYtApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReactiveProgrammingYtApplication.class, args);
	}
	
	@Bean
	public ConnectionFactory connectionFactory() {
	    return ConnectionFactories.get("r2dbc:mysql://localhost:3306/your_database");
	}

	@Bean
	public R2dbcEntityTemplate r2dbcEntityTemplate(ConnectionFactory connectionFactory) {
	    return new R2dbcEntityTemplate(connectionFactory);
	}
}
