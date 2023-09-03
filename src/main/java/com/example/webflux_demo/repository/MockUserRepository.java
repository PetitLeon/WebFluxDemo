package com.example.webflux_demo.repository;

import com.example.webflux_demo.entity.User;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Repository
public class MockUserRepository {
    private static void threadSleep(long l){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public List<User> findAllBlock() {
        return IntStream.range(1,10)
                .peek(MockUserRepository::threadSleep)
                .mapToObj(i->new User(i,"user"+i,10))
                .collect(Collectors.toList());
    }

    public Flux<User> findAll() {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .map(l->new User(l,"user"+l,10));
    }
}
