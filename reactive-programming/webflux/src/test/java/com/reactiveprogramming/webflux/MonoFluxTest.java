package com.reactiveprogramming.webflux;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {
    @Test
    public void testMono() {
        Mono<String> monoString = Mono.just("Hello").log();
        monoString.subscribe(System.out::println); // prints "Hello" in console
    }

    public void testFlus() {
        Flux<String> fluxString = Flux.just("test", "flux", "spring boot");
        fluxString.subscribe(System.out::println); // print line by line all the strings present in flux
    }
}
