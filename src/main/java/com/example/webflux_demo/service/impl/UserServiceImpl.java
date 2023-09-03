package com.example.webflux_demo.service.impl;

import com.example.webflux_demo.entity.User;
import com.example.webflux_demo.repository.MockUserRepository;
import com.example.webflux_demo.repository.UserRepository;
import com.example.webflux_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    MockUserRepository mockUserRepository;
    public Mono<User> findById(Long id){
        return userRepository.findById(id);
    }

    @Override
    public Mono<User> createUser(User user) {
        Mono<User> userMono = userRepository.save(user);
        return userMono;
    }

    @Override
    public Flux<User> batchCreate(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAllBlock() {
        long t1 = System.currentTimeMillis();
        List<User> users = mockUserRepository.findAllBlock();
        long t2 = System.currentTimeMillis();
        System.out.println(String.format("block查询用时：%s ms",t2-t1));
        return users;
    }

    @Override
    public Flux<User> findAllUserSubscribe() {
        long t1 = System.currentTimeMillis();
        Flux<User> users = mockUserRepository.findAll();
        long t2 = System.currentTimeMillis();
        System.out.println(String.format("unblock查询用时：%s ms",t2-t1));
        return users;
    }
}
