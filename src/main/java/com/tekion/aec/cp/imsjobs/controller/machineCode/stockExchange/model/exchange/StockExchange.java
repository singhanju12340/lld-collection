package com.tekion.aec.cp.imsjobs.controller.machineCode.stockExchange.model.exchange;

import com.tekion.aec.cp.imsjobs.controller.machineCode.stockExchange.model.order.OrderBook;
import com.tekion.aec.cp.imsjobs.controller.machineCode.stockExchange.model.stock.Stock;

/**
 * @author anju
 * @created on 06/01/25 and 4:42 PM
 */
public interface StockExchange {


    void addStock(Stock stock, Integer quantity);
    void removeStock(Stock stock);

    void updateStock(Stock stock);

    OrderBook getOrderBook(Stock stock);
}
