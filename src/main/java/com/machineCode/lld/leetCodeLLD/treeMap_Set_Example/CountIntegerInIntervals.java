package com.machineCode.lld.leetCodeLLD.treeMap_Set_Example;


import java.util.Map;
import java.util.TreeMap;

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

public class CountIntegerInIntervals {
    private TreeMap<Integer, Interval> map;
    private int totalCoverage;

    public CountIntegerInIntervals() {
        map = new TreeMap<>();
        totalCoverage = 0;
    }


    public void add(int left, int right) {
        // basic check
        if (left > right) return;

        // We'll define mergedStart/mergedEnd
        int mergedStart = left;
        int mergedEnd   = right;

        // 1) Find the first interval that could overlap or touch
        Map.Entry<Integer, Interval> startEntry = map.floorEntry(left);

        // Possibly move backward if there's an interval that starts before 'left'
        // but we need to check overlap by end >= left-1
        if (startEntry != null) {
            Interval iv = startEntry.getValue();
            if (iv.end >= left - 1) { // iv.end >= left  also works
                mergedStart = Math.min(mergedStart, iv.start);
                mergedEnd   = Math.max(mergedEnd, iv.end);
                // remove coverage
                totalCoverage -= (iv.end - iv.start + 1);
                map.remove(iv.start);
            }
        }

        // 2) Merge forward while next interval overlaps/abuts [mergedStart, mergedEnd]
        Map.Entry<Integer, Interval> nextEntry = map.higherEntry(
                (startEntry == null ? left : startEntry.getKey()));


        while (nextEntry != null) {
            Interval curr = nextEntry.getValue();
            if (curr.start <= mergedEnd ) { // this works for interval [5,6][7,8]
//          if (curr.start <= mergedEnd +1) { this also works for [5,8],  [5,6][7,8] / [5,8] both will have same count of integers

                    // Overlap or adjacent
                    mergedStart = Math.min(mergedStart, curr.start);
                    mergedEnd   = Math.max(mergedEnd, curr.end);
                    // remove coverage
                    totalCoverage -= (curr.end - curr.start + 1);
                    map.remove(curr.start);

                    nextEntry = map.higherEntry(curr.start);
                } else {
                    break;
                }

        }

        // 3) Insert the merged interval
        map.put(mergedStart, new Interval(mergedStart, mergedEnd));
        // 4) Add coverage for the newly formed interval
        totalCoverage += (mergedEnd - mergedStart + 1);
    }

    public int count() {
        return totalCoverage;
    }

    public static void main(String[] args) {
        CountIntegerInIntervals countIntegerInIntervals = new CountIntegerInIntervals();
        countIntegerInIntervals.add(2,3);
        countIntegerInIntervals.add(8,9);

        System.out.println(countIntegerInIntervals.count());

        countIntegerInIntervals.add(7,10);

        System.out.println(countIntegerInIntervals.count());

        countIntegerInIntervals.add(5,8);

    }
}
