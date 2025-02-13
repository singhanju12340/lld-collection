package com.machineCode.stockExchange.model.stock;

/**
 * @author anju
 * @created on 05/08/24 and 12:59 PM
 */
public class Stock {
    String id;
    String name;
    Double launchPrice;

    public Stock(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.launchPrice = price;
    }

}
