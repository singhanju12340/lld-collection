package com.machineCode.application;

import com.machineCode.splitwise.models.User;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author anju
 * @created on 16/02/25 and 11:58 AM
 */
public class TestReactorProgramming {
    private static final WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8080")
//                .defaultHeader("Authorization", "Bearer YOUR_ACCESS_TOKEN")
            .build();

    public static void main(String[] args) {
//        new TestReactorProgramming().testWebclient();
//        testConcat();
//        testBackPressure();
        System.out.println(new TestReactorProgramming().findUserById(1));



    }


    public static void testFlux(){
        Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5)
                .concatWith(Flux.error(new RuntimeException("Oops! An error occurred.")))
                .map(number -> 10 / (number - 3)) // This will cause an ArithmeticException
                .doOnError(throwable -> System.err.println("Error occurred: " + throwable.getMessage()))
                .onErrorReturn(-1); // Provide a fallback value in case of an error

        numbers.subscribe(
                value -> System.out.println("Received: " + value),
                error -> System.err.println("Subscriber error: " + error.getMessage())
        );
    }

    public static void testConcat(){
        Flux<String> morningTasks = Flux.just("Check emails", "Team meeting");
        Flux<String> eveningTasks = Flux.just("Project review", "Prepare report");

        morningTasks = morningTasks.concatWith(Flux.error(new RuntimeException("error error")));

        Flux<String> allDailyTasks = Flux.concatDelayError(morningTasks, eveningTasks);
//        allDailyTasks.subscribe(System.out::println, System.err::println);

        allDailyTasks.subscribe(System.out::println, error -> System.err.println("Error: " + error.getMessage()));

    }

    public static void testBackPressure(){
        Flux<Integer> fastProducer = Flux.range(1, 1000);
        Flux<Integer> bufferedConsumer = fastProducer.onBackpressureBuffer(4);

        fastProducer.subscribe(
                value -> {
                    // Simulate slow processing
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + " : " +value);
                }
        );

    }

    public static Mono<User> findUserById(int id){
        return new TestReactorProgramming().webClient.get().uri("/user/{id}",id)
                .retrieve()
                .bodyToMono(User.class);
    }

    public void testWebclient(){

        Flux<User> responseMono = this.webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToFlux(User.class);

        System.out.println("dgfhjklfghjk");

        responseMono.subscribe(
                response -> System.out.println("Response: " + response),
                error -> System.err.println("Error: " + error.getMessage())
        );

    }
}
