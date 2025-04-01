package com.reactive.programming;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@SuppressWarnings("unused")
@SpringBootTest
class ReactiveProgrammingYtApplicationTests {
	@Test
	void workingWithMono() {
		// error mono
//		Mono<String> errorMono = Mono.error(new RuntimeException("Error !!"));
		
		// Mono means publisher that have zero ... one items
//		Mono<String> mono1 = Mono.just("Learning Mono").log().then(errorMono); // created mono
				
		// consuming mono by subscribing
//		mono1.subscribe(System.out::println);
		
		// consuming error mono
//		errorMono.subscribe(System.out::println);
		
		
		// merging mono
		@SuppressWarnings("unused")
		Mono<String> m1 = Mono.just("Mono 1");
		@SuppressWarnings("unused")
		Mono<String> m2 = Mono.just("Mono 2");
//		Mono<Tuple2<String, String>> combinedMono = Mono.zip(m1, m2); // using zip method
		
//		System.out.println("Using zip method");
//		combinedMono.subscribe(data -> {
//			System.out.println(data.getT1()); // give m1 string
//			System.out.println(data.getT2()); // give m2 string
//		});
		
		// another way to merge
//		Mono<Tuple2<String, String>> zipWithMono = m1.zipWith(m2);
//		System.out.println("Using zipWith method");
//		zipWithMono.subscribe(data -> {
//			// using zipWith method
//			System.out.println(data.getT1());
//			System.out.println(data.getT2());
//		});
		
		// using map function -> to transform the mono 
//		Mono<String> resultMapMono = m1.map(item -> item.toUpperCase());
//		resultMapMono.subscribe(System.out::println);
		
		
		// use of flatMap() -> value emitted by another mono will be used here 
//		Mono<String[]> monoFlatMap = m1.flatMap(valueM1 -> Mono.just(valueM1.split(" ")));
//		monoFlatMap.subscribe(data -> {
//			for(String s: data) {
//				System.out.println(s);
//			}
//		});
		
		// use of flatMapMany() -> returns the emitted flux
//		Flux<String> fluxString = m1.flatMapMany(valueM1 -> Flux.just(valueM1.split(" "))).log();
//		fluxString.subscribe(data -> {
//			System.out.println(data);
//		});
	}
}
