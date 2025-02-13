package com.tekion.aec.cp.imsjobs.controller.machineCode.stockExchange.model.order;

import com.tekion.aec.cp.imsjobs.controller.machineCode.stockExchange.model.User;
import com.tekion.aec.cp.imsjobs.controller.machineCode.stockExchange.model.stock.Stock;
import com.tekion.aec.cp.imsjobs.controller.machineCode.stockExchange.model.stockEnums.TxnType;

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
