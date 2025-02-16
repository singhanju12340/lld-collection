package com.machineCode.application;

import com.machineCode.splitwise.models.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author anju
 * @created on 15/02/25 and 11:06 PM
 */

@RestController
@RequiredArgsConstructor
@Slf4j
public class controller {

    private final UserService userService;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }


    @GetMapping("/hello/reactor")
    public Mono<String> hello() {
        // Mono.just creates a reactive publisher that emits a single value.
        return Mono.just("Hello from Project Reactor with Spring Boot!");
    }

    @GetMapping("/users/{id}")
    public Mono<ResponseEntity<User>> getUserById(@PathVariable String id) {
        return userService.getUserById(id)
                .onErrorResume(throwable -> {
                    log.error("failed to fetch user"); // will fail for userid=2
                    return Mono.just(null);
                })
                .onErrorReturn(null)
                .map(user -> ResponseEntity.ok(user))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/users/invalid/{id}")
    public Mono<ResponseEntity<User>> getUserbyIdReturnOnError(@PathVariable String id) {
        return userService.getUserById(id)
                .doOnError(error -> log.error("User id is invalid"))
                .onErrorReturn(new User("0", "new user", 8230923L))
                .map(user -> ResponseEntity.ok(user))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/users")
    public Flux<User> getAllUsers() {
        System.out.println("users api called");
        return userService.getAllUsers();
    }


}
