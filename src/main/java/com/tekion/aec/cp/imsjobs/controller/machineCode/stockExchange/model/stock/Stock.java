package com.tekion.aec.cp.imsjobs.controller.machineCode.stockExchange.model.stock;

import com.tekion.aec.cp.imsjobs.controller.machineCode.stockExchange.model.stockEnums.ExchangeType;

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
