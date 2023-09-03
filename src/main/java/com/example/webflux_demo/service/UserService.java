package com.example.webflux_demo.service;

import com.example.webflux_demo.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserService {
    Mono<User> findById(Long id);

    Mono<User> createUser(User user);
    Flux<User> findAll();

    Flux<User> batchCreate(List<User> users);

    List<User> findAllBlock();

    Flux<User> findAllUserSubscribe();
}
