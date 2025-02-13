package com.tekion.aec.cp.imsjobs.controller.machineCode.stockExchange;

import com.tekion.aec.cp.imsjobs.controller.machineCode.stockExchange.model.exchange.NSEStockExchange;
import com.tekion.aec.cp.imsjobs.controller.machineCode.stockExchange.model.exchange.StockExchange;
import com.tekion.aec.cp.imsjobs.controller.machineCode.stockExchange.model.stock.Stock;

/**
 * @author anju
 * @created on 06/01/25 and 5:31 PM
 */
public class StockExchangeTest {


    public static void main(String[] args) {
        StockExchange stockExchange = NSEStockExchange.getNseStockExchangeInstance();

        // add stock
        stockExchange.addStock(new Stock("1", "Zamato", 109.30), 1000);
        stockExchange.addStock(new Stock("2", "Swiggy", 203.30), 500);

        // add user

        // buy stock by user 1
        // sell stock by user 2

        // fetch order book






    }
}
