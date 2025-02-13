package com.machineCode.designPatterns.behavioral.observerPatterns;

import java.util.Arrays;

/**
 * @author anju
 * @created on 12/02/25 and 1:30 PM
 */
public class ShopObserDemo {

    public static void main(String[] args) {
        ShopManager<User> shopManager = new ShopManager<>();

        shopManager.subscribe(Arrays.asList(new User("anju")));
        shopManager.subscribe(Arrays.asList(new User("gopal")));

        shopManager.setPhoneCount(23);
    }
}
