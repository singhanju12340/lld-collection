package com.machineCode.parkingLot.models;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author anju
 * @created on 19/03/25 and 3:33 PM
 */
public class Terminal {
    //its an entry and exit

    String name;
    Integer id;
    PriorityQueue minHeap=new PriorityQueue(); // min heap to store parking slot based on distance from current terminal
}
