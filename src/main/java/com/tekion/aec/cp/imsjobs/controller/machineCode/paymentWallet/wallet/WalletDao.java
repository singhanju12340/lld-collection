package com.tekion.aec.cp.imsjobs.controller.machineCode.paymentWallet.wallet;

import java.math.BigDecimal;

/**
 * @author anju
 * @created on 07/01/25 and 12:50 PM
 */
public class WalletDao {

    String id;
    String name;
    String type;
    BigDecimal balance;

    public WalletDao(String id, String name, String type, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
