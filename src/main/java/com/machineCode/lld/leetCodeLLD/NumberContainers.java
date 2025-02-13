package com.machineCode.lld.leetCodeLLD;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author anju
 * @created on 04/02/25 and 1:49 PM
 */
public class NumberContainers {
    /***
     * Design a number container system that can do the following:
     *
     * Insert or Replace a number at the given index in the system.
     * Return the smallest index for the given number in the system.
     * Implement the NumberContainers class:
     *
     * NumberContainers() Initializes the number container system.
     * void change(int index, int number) Fills the container at index with the number. If there is already a number at that index, replace it.
     * int find(int number) Returns the smallest index for the given number, or -1 if there is no index that is filled by number in the system.
     *
     *
     * Example 1:
     *
     * Input
     * ["NumberContainers", "find", "change", "change", "change", "change", "find", "change", "find"]
     * [[], [10], [2, 10], [1, 10], [3, 10], [5, 10], [10], [1, 20], [10]]
     * Output
     * [null, -1, null, null, null, null, 1, null, 2]
     */

    class NumbIndex{
        int number;
        int index;
        NumbIndex(int number, int index){
            this.number = number;
            this.index = index;
        }
    }
    Map<Integer, PriorityQueue<NumbIndex>> orderMap;
    Map<Integer, NumbIndex> indexObjMap;

    public NumberContainers() {
        orderMap = new HashMap<>();
        indexObjMap = new HashMap<>();
    }

    public void change(int index, int number) {
        this.orderMap.putIfAbsent(number, new PriorityQueue<>(new Comparator<NumbIndex>(){
                    @Override
                    public int compare(NumbIndex n1, NumbIndex n2){
                        return n1.index - n2.index;
                    }
                })
        );

        if(indexObjMap.containsKey(index)){
            NumbIndex object = indexObjMap.get(index); // fetch old number object stored at current index
            PriorityQueue queue = orderMap.get(object.number); // get older queue from where this needs to be removed
            queue.remove(object);
            if(queue.isEmpty())
                orderMap.remove(object.number);
        }

        this.orderMap.putIfAbsent(number, new PriorityQueue<>(new Comparator<NumbIndex>(){
                    @Override
                    public int compare(NumbIndex n1, NumbIndex n2){
                        return n1.index - n2.index;
                    }
                })
        );

        // index into new number priority queue
        NumbIndex numbObj = new NumbIndex(number, index);
        orderMap.get(number).add(numbObj);
        // update index to number object map
        indexObjMap.put(index, numbObj);
    }

    public int find(int number) {
        if(!orderMap.containsKey(number))
            return -1;
        return orderMap.get(number).peek().index;
    }

    public static void main(String[] args) {

//        NumberContainers numberContainers = new NumberContainers();
//        System.out.println(numberContainers.find(10));
//        numberContainers.change(2,10);
//        numberContainers.change(1,10);
//        numberContainers.change(3,10);
//        numberContainers.change(5,10);
//        System.out.println(numberContainers.find(10));
//        numberContainers.change(1,20);
//        System.out.println(numberContainers.find(10));

        // Set 2

//        NumberContainers numberContainers = new NumberContainers();
//        numberContainers.change(1,10);
//        System.out.println(numberContainers.find(10));
//
//        numberContainers.change(1,20);
//        System.out.println(numberContainers.find(10));
//
//        System.out.println(numberContainers.find(20));
//        System.out.println(numberContainers.find(30));


        // set 3


        NumberContainers numberContainers = new NumberContainers();
        numberContainers.change(1,10);
        numberContainers.change(1,10);

        System.out.println(numberContainers.find(10));

        numberContainers.change(1,20);
        System.out.println(numberContainers.find(10));

    }

}
