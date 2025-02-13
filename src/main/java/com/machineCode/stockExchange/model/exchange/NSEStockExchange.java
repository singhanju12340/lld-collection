package com.machineCode.stockExchange.model.exchange;

import com.machineCode.stockExchange.model.order.OrderBook;
import com.machineCode.stockExchange.model.stockEnums.ExchangeType;
import com.machineCode.stockExchange.model.stock.Stock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author anju
 * @created on 06/01/25 and 4:43 PM
 */
public class NSEStockExchange extends StockExchangeMetadata implements StockExchange {
    private Map<Stock, Integer> NSEStocks;
    private Map<Stock, OrderBook> stockOrderBook;


    private static NSEStockExchange nseStockExchange;

    private NSEStockExchange(){
        super(ExchangeType.NSE.name(), "NSE Stock Exchange", ExchangeType.NSE);
        NSEStocks = new ConcurrentHashMap<>();
    }

    public static NSEStockExchange getNseStockExchangeInstance(){
        if(null == nseStockExchange)
                return new NSEStockExchange();
        return nseStockExchange;
    }

    @Override
    public void addStock(Stock stock, Integer quantity) {

    }

    @Override
    public void removeStock(Stock stock) {

    }

    @Override
    public void updateStock(Stock stock) {

    }

    @Override
    public OrderBook getOrderBook(Stock stock) {
        return stockOrderBook.get(stock);
    }


}
