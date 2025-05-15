package com.machineCode.lld.leetCodeLLD.treeMap_Set_Example;


import java.util.*;

/**
 * @author anju
 * @created on 04/02/25 and 6:07 PM
 */

/***
 * Given an empty set of intervals, implement a data structure that can:
 *
 * Add an interval to the set of intervals.
 * Count the number of integers that are present in at least one interval.
 * Implement the CountIntervals class:
 *
 * CountIntervals() Initializes the object with an empty set of intervals.
 * void add(int left, int right) Adds the interval [left, right] to the set of intervals.
 * int count() Returns the number of integers that are present in at least one interval.
 * Note that an interval [left, right] denotes all the integers x where left <= x <= right.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["CountIntervals", "add", "add", "count", "add", "count"]
 * [[], [2, 3], [7, 10], [], [5, 8], []]
 * Output
 * [null, null, null, 6, null, 8]
 */

public class CountIntegerInIntervalsByTreeSet {
    private TreeSet<Interval> intervals;
    private int totalCoverage;


    public CountIntegerInIntervalsByTreeSet(){
        intervals = new TreeSet<>((a,b)->a.start - b.start); // sorted by  start time

    }




    public void add(int left, int right) {
        if (left > right) return;

        // get nearest lowest element from left
        Interval prev = intervals.floor(new Interval(left, left));

        // merge if there is over lapping set. where start<= current left
        if (prev != null && prev.end >= left - 1) {
            left = Math.min(left, prev.start);
            right = Math.max(right, prev.end);
            totalCoverage -= (prev.end - prev.start + 1);
            intervals.remove(prev);
        }
// get all sets after current left.
        Iterator<Interval> it = intervals.tailSet(new Interval(left, left), true).iterator();

        // merge if overlap else ignore
        while (it.hasNext()) {
            Interval curr = it.next();
            // if its right side in the sequence ignore
            if (curr.start > right) break; // No more overlaps

            // Merge overlapping intervals
            left = Math.min(left, curr.start);
            right = Math.max(right, curr.end);
            totalCoverage -= (curr.end - curr.start + 1);
            it.remove();
        }

        // Add the merged interval
        intervals.add(new Interval(left, right));
        totalCoverage += (right - left + 1);
    }


    public int count() {
        return totalCoverage;
    }

    public static void main(String[] args) {
        CountIntegerInIntervalsByTreeSet countIntegerInIntervals = new CountIntegerInIntervalsByTreeSet();
//        countIntegerInIntervals.add(2,3);
//        countIntegerInIntervals.add(8,9);

//        countIntegerInIntervals.add(1,2);
//        countIntegerInIntervals.add(4,6);
//        countIntegerInIntervals.add(3,8);


        countIntegerInIntervals.add(1,4);
        countIntegerInIntervals.add(8,9);
        countIntegerInIntervals.add(3,6);
        System.out.println(countIntegerInIntervals.count());

        countIntegerInIntervals.add(10,15);

        System.out.println(countIntegerInIntervals.count());

        countIntegerInIntervals.add(5,8);

    }
}
