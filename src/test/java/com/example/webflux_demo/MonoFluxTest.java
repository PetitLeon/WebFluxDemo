package com.example.webflux_demo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;


public class MonoFluxTest {
    @Test
    public void testMono(){
        Mono<String> stringMono = Mono.just("test");
        stringMono.subscribe(System.out::println);
    }
    @Test
    public void FluxTest(){
        Flux<String> stringFlux = Flux.just("spring", "boot", "webflux")
                .log()
                .concatWithValues("reactive");
        stringFlux.subscribe(System.out::println);
    }
}
