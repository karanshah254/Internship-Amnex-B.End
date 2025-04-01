package com.reactive.programming;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reactive.programming.services.FluxService;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SuppressWarnings("unused")
@SpringBootTest
public class FluxTest {
	@Autowired
	private FluxService fluxService;

	// @Test
	// public void simpleFluxTest() {
	// fluxService.getFlux().subscribe(data -> {
	// System.out.println(data);
	// System.out.println("DOne with flux");
	// });

	// fluxService.getFruits().subscribe(System.out::println);
	// }

	// @Test
	// public void MapTest() {
	// fluxService.mapExample().subscribe(data -> {
	// System.out.println(data);
	// });
	// }

	// @Test
	// public void mapTest() {
	// Flux<String> capFlux = fluxService.mapExample();
	// StepVerifier.create(capFlux).expectNextCount(4).verifyComplete();
	// }

	// @Test
	// public void filterTestExample() {
	// Flux<String> filterByLength = fluxService.filterExample();
	// StepVerifier.create(filterByLength).expectNextCount(1).verifyComplete();
	//
	// }

	// @Test
	// public void flatMapTest() {
	// Flux<String> flatMapFlux = fluxService.flatMapExample().log();
	// StepVerifier.create(flatMapFlux).expectNextCount(4).verifyComplete();
	// }

	// @Test
	// public void tranformTest() {
	// Flux<?> flux = fluxService.transformExample();
	// StepVerifier.create(flux).expectNextCount(4).verifyComplete();
	// }
	
	@Test
	public void sideEffectTest() {
		fluxService.sideEffecExample().subscribe(System.out::println);
	}
}
