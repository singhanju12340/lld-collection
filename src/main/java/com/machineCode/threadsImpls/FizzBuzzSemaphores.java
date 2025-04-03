package com.machineCode.threadsImpls;

import java.util.ConcurrentModificationException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @author anju
 * @created on 26/03/25 and 7:44 PM
 */
public class FizzBuzzSemaphores {
    private int n;
    Semaphore semaphoreA;
    Semaphore semaphoreB;
    Semaphore semaphoreC;
    Semaphore semaphoreD;
    private static int count;


    public FizzBuzzSemaphores(int n) {
        this.n = n;
        semaphoreA = new Semaphore(0);
        semaphoreB = new Semaphore(0);
        semaphoreC = new Semaphore(0);
        semaphoreD = new Semaphore(0);
    }



    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (count<=n){
//             System.out.println(">> "+count);
            semaphoreA.acquire();
            if(count%3==0 && count % 5 != 0){
                printFizz.run();
                count++;
            }
            semaphoreA.release();

        }

    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {

        while (count<=n){
//            System.out.println("::"+count);
            if (count % 5 == 0 && count % 3!=0){
                semaphoreB.acquire();
                printBuzz.run();
//                Thread.sleep(30);
                count++;
                semaphoreB.release();

            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (count<=n){
//            System.out.println("---"+count);

            if (count % 15 == 0){
                semaphoreC.acquire();
                printFizzBuzz.run();
//                Thread.sleep(100);
                semaphoreC.release();
            }


        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (count<=n){
            if (count % 3 != 0 && count % 5 != 0) {
                semaphoreD.acquire();
                printNumber.accept(count);
                semaphoreD.release();
            }
        }
    }


    public static void main(String[] args) {
        Runnable fizz = (()->{System.out.println("fizz");});
        Runnable buzz = (()->{System.out.println("buzz");});
        Runnable fbuzz = (()->{System.out.println("fizzbuzz");});
        IntConsumer number = System.out::println;

        FizzBuzzSemaphores fizzBuzzSemaphores = new FizzBuzzSemaphores(15);

        new Thread(()->{
            try {
                fizzBuzzSemaphores.fizz(fizz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                fizzBuzzSemaphores.buzz(buzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                fizzBuzzSemaphores.fizzbuzz(fbuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                fizzBuzzSemaphores.number(number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }

}
