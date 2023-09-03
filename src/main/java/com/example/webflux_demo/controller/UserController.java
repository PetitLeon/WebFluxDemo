package com.example.webflux_demo.controller;

import com.example.webflux_demo.entity.User;
import com.example.webflux_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/create")
    public Mono<User> createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @PostMapping("/batch")
    public Flux<User> batchCreate(@RequestBody List<User> users){
        return userService.batchCreate(users);
    }
    @GetMapping("/{id}")
    public Mono<User> findById(@PathVariable Long id){
        return userService.findById(id);
    }
    @GetMapping(value = "/all",produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<User> findAll(){
        Flux<User> userFlux = userService.findAll();
        return userFlux;
    }

    @GetMapping("/block")
    public List<User> blockQuery(){
        return userService.findAllBlock();
    }
    @GetMapping(value = "/subscribe",produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<User> subscribe(){
        return userService.findAllUserSubscribe();
    }
}
