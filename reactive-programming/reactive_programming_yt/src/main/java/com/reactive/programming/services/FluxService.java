package com.reactive.programming.services;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class FluxService {
	// create a flux
	public Flux<String> getFlux() {
		return Flux.just("John, Jane, Bob, Alice");
	}

	public Flux<String> getFruits() {
		List<String> names = List.of("Apple", "Banana");
		return Flux.fromIterable(names).log();
	}

	// map in flux -> convert to upper-case
	public Flux<String> mapExample() {
		return getFlux().map(name -> name.toUpperCase());
	}

	// filter data
	public Flux<String> filterExample() {
		return getFlux().filter(name -> name.length() > 4).log();
	}

	// flat-map
	public Flux<String> flatMapExample() {
		return getFlux().flatMap(name -> Flux.just(name.split(" "))).delayElements(Duration.ofMillis(2000)).log();
	}

	// transform example
	Function<Flux<String>, Flux<String>> functionInterface = (name) -> name.map(String::toUpperCase);

	public Flux<?> transformExample() {
		return getFlux().transform(functionInterface).log();
	}

	// side effect
	public Flux<String> sideEffecExample() {
		return getFlux().doOnNext(data -> {
			System.out.println(data + " on next!");
		}).doOnSubscribe(data -> {
			System.out.println(data + " on subscribe");
		}).log();
	}
}
