package com.machineCode.stockExchange.model.order;

import com.machineCode.stockExchange.model.User;
import com.machineCode.stockExchange.model.stockEnums.TxnType;
import com.machineCode.stockExchange.model.stock.Stock;

/**
 * @author anju
 * @created on 06/01/25 and 5:18 PM
 */
public class StockOrder {
    Stock stock;
    Integer quantity;
    TxnType type;
    Double price;
    User user;
}
