package com.machineCode.application;

import com.machineCode.splitwise.models.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author anju
 * @created on 15/02/25 and 11:13 PM
 */

@Service

public class UserService {



    public Mono<User> getUserById(String id) {
        // For demonstration, we'll return a dummy user if id equals "1" and empty otherwise.
        if ("1".equals(id)) {
            System.out.println("asaas");
            User user = new User("1", "John Doe", 1232423L);
            return Mono.just(user);
        }else if("2".equals(id)){
            throw new RuntimeException("Error while finding User");
        }
        return Mono.empty();
    }



    public Flux<User> getAllUsers() {
        // For demonstration, we'll return a dummy user if id equals "1" and empty otherwise.
        User user1 = new User("1", "John Doe", 1232423L);
        User user2 = new User("2", "Anju Doe", 190423L);
        User user3 = new User("3", "Mark Doe", 1200423L);
        User user4 = new User("4", "Karina Doe", 12423L);

        return Flux.just(user1, user2, user3, user4);
    }
}
