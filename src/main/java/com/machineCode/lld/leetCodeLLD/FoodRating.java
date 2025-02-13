package com.machineCode.lld.leetCodeLLD;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author anju
 * @created on 31/01/25 and 12:06 PM
 */
public class FoodRating {
    /****
     * Design a food rating system that can do the following:
     *
     * Modify the rating of a food item listed in the system.
     * Return the highest-rated food item for a type of cuisine in the system.
     * Implement the FoodRatings class:
     *
     * FoodRatings(String[] foods, String[] cuisines, int[] ratings) Initializes the system. The food items are described by foods, cuisines and ratings, all of which have a length of n.
     * foods[i] is the name of the ith food,
     * cuisines[i] is the type of cuisine of the ith food, and
     * ratings[i] is the initial rating of the ith food.
     * void changeRating(String food, int newRating) Changes the rating of the food item with the name food.
     * String highestRated(String cuisine) Returns the name of the food item that has the highest rating for the given type of cuisine. If there is a tie, return the item with the lexicographically smaller name.
     * Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.
     *
     *
     *
     * Example 1:
     *
     * Input
     * ["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"]
     * [[["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]], ["korean"], ["japanese"], ["sushi", 16], ["japanese"], ["ramen", 16], ["japanese"]]
     * Output
     * [null, "kimchi", "ramen", null, "sushi", null, "ramen"]
     */

    Map<String, FoodDetails> foodMap = new HashMap<>();
    Map<String, PriorityQueue<FoodDetails>> cuisinePriorityMap;

    class FoodDetails{
        String name;
        String cuisine;
        int rating;

        public FoodDetails(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }


    public FoodRating(String[] foods, String[] cuisines, int[] ratings) {
        this.foodMap = new HashMap<>();
        this.cuisinePriorityMap = new HashMap<>();

        for(int i=0;i<foods.length;i++){
            FoodDetails foodDetails = new FoodDetails(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], foodDetails);
            cuisinePriorityMap.putIfAbsent(cuisines[i], new PriorityQueue<>(new Comparator<FoodDetails>() {
                @Override
                public int compare(FoodDetails o1, FoodDetails o2) {
                    if(o1.rating == o2.rating)
                        return o1.name.compareTo(o2.name); // assending
                    else return o2.rating - o1.rating; // decending
                }
            }));
            cuisinePriorityMap.get(cuisines[i]).add(foodDetails);
        }
    }

    public void changeRating2(String food, int newRating) {
        FoodDetails fd = foodMap.get(food);

        FoodDetails fdNew = new FoodDetails(food, fd.cuisine, newRating);
        fd.name=""; // make older rating redundent
        cuisinePriorityMap.get(fd.cuisine).add(fdNew);
    }

    public void changeRating(String food, int newRating) {
        FoodDetails curr = foodMap.get(food);
        PriorityQueue<FoodDetails> pq = cuisinePriorityMap.get(curr.cuisine);
        pq.remove(curr);
        curr.rating = newRating;
        pq.add(curr);
    }

    public String highestRated2(String cuisine) {
        PriorityQueue<FoodDetails> pq = cuisinePriorityMap.get(cuisine);

        while (cuisinePriorityMap.get(cuisine).peek().name == ""){
            cuisinePriorityMap.get(cuisine).remove();
        }
        return pq.peek().name;
    }

    public String highestRated(String cuisine) {
        PriorityQueue<FoodDetails> pq = cuisinePriorityMap.get(cuisine);
        return pq.peek().name;
    }

    public static void main(String[] args) {
//        String[] foods = {"burger", "pizza", "sandwich", "pizzaHut"};
//        String[] cuisines = {"american", "italian", "american", "italian"};
//        int[] ratings = {10, 15, 12, 15};

//        FoodRating fr = new FoodRating(foods, cuisines, ratings);
//
//        System.out.println(fr.highestRated("italian")); // Should print "pizza" or "pizzaHut" based on lexicographic tie
//        // "pizza" < "pizzaHut" lexicographically, so expects "pizza"
//
//        fr.changeRating("pizzaHut", 20); // Now "pizzaHut" rating is 20
//        System.out.println(fr.highestRated("italian")); // Should print "pizzaHut"
//
//        fr.changeRating("pizza", 20);  // "pizza" rating also 20
//        // Now we have "pizzaHut" (20) and "pizza" (20), tie => lexicographically smaller is "pizza"
//        System.out.println(fr.highestRated("italian")); // Should print "pizza"

        // sample 2
        String[] foods = {"kimchi","miso","sushi","moussaka","ramen","bulgogi"};
        String[] cuisines = {"korean","japanese","japanese","greek","japanese","korean"};
        int[] ratings = {9,12,8,15,14,7};
        FoodRating fr = new FoodRating(foods, cuisines, ratings);

        System.out.println(fr.highestRated("korean"));
        System.out.println(fr.highestRated("japanese"));
        fr.changeRating("sushi", 16);
        System.out.println(fr.highestRated("japanese"));
        fr.changeRating("ramen", 16);
        System.out.println(fr.highestRated("japanese"));



    }

}
