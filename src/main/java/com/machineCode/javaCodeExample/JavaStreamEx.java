package com.machineCode.javaCodeExample;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class JavaStreamEx {
    private static void getMax(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.stream().max(Integer::compareTo).ifPresent(System.out::println);
    }

    private static void groupCount(){
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> wordCounts = words.stream().collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println(wordCounts);


    }



    public static void main(String[] args) {
        getMax();




        Map<String, String> map = new HashMap<>();
        map.put("name", "<anju>");
        map.put("age", "1");
        map.put("age", "2");

        map.put("name", "<manju>");
        map.put("name", "<sanju>");
        map.put("name", "<sanju>");


    }
}
