package com.tekion.aec.cp.imsjobs.controller.machineCode.stockExchange.model.exchange;

import com.tekion.aec.cp.imsjobs.controller.machineCode.stockExchange.model.stockEnums.ExchangeType;

/**
 * @author anju
 * @created on 06/01/25 and 4:59 PM
 */
public class StockExchangeMetadata {
    String id;
    String name;
    ExchangeType exchangeType;

    public StockExchangeMetadata(String id, String name, ExchangeType exchangeType) {
        this.id = id;
        this.name = name;
        this.exchangeType = exchangeType;
    }
}
