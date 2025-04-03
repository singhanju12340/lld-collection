package com.machineCode.threadsImpls;

import java.util.ConcurrentModificationException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @author anju
 * @created on 26/03/25 and 4:29 PM
 */
public class FizzBuzz {

    private int n;
    private AtomicInteger counter;

    public FizzBuzz(int n) {
        this.n = n;
        counter = new AtomicInteger(1);
    }

    private void updateToNext(int count) {
        if (!counter.compareAndSet(count, count + 1)){
//            counter.getAndIncrement();
                        throw new ConcurrentModificationException();

        }
//            throw new ConcurrentModificationException();
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        int count;

        while ((count = counter.get())<=n){
//             System.out.println(">> "+count);

            if(count%3==0 && count % 5 != 0){
                printFizz.run();
                updateToNext(count);
            }
        }

    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        int count;

        while ((count = counter.get())<=n) {
//            System.out.println("::"+count);
            if (count % 5 == 0 && count % 3!=0){
                printBuzz.run();
//                Thread.sleep(30);

                updateToNext(count);

            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        int count;
        while ((count = counter.get())<=n) {
//            System.out.println("---"+count);

            if (count % 15 == 0){
                printFizzBuzz.run();
//                Thread.sleep(100);

                updateToNext(count);
            }


        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        int count;
        while ((count = counter.get()) <= n) {
            if (count % 3 != 0 && count % 5 != 0) {
                printNumber.accept(count);
                updateToNext(count);
            }
        }
    }




    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Runnable fizz = () -> System.out.println(Thread.currentThread() + " fizz");
        Runnable buzz = () -> System.out.println(Thread.currentThread()+" buzz");
        Runnable fBuzz = () -> System.out.println(Thread.currentThread()+" fizzbuzz");

        IntConsumer number = System.out::println;


        new Thread(() -> {

            try {
                fizzBuzz.fizz(fizz);
            } catch (InterruptedException e) {

                e.printStackTrace();

                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {

            try {
                fizzBuzz.buzz(buzz);
            } catch (InterruptedException e) {

                e.printStackTrace();

                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {

            try {
                fizzBuzz.fizzbuzz(fBuzz);
            } catch (InterruptedException e) {

                e.printStackTrace();

                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {

            try {
                fizzBuzz.number(number);
            } catch (InterruptedException e) {

                e.printStackTrace();

                throw new RuntimeException(e);
            }
        }).start();

    }
}
