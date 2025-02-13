package com.machineCode.stockExchange.model.order;

import java.util.PriorityQueue;

/**
 * @author anju
 * @created on 06/01/25 and 5:23 PM
 */
public class OrderBook {
    private PriorityQueue<StockOrder> buyOrders;
    private PriorityQueue<StockOrder> sellOrders;

    public OrderBook() {
        this.buyOrders = new PriorityQueue<StockOrder>((o1,o2) -> (int) (o1.price-o2.price));
        this.sellOrders =  new PriorityQueue<StockOrder>((o1,o2) -> (int) (o1.price-o2.price));;
    }



    public void addOrder(){

    }

    public void cancelOrder(){

    }




}
