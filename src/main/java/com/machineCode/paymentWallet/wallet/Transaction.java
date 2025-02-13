package com.machineCode.paymentWallet.wallet;

import com.machineCode.paymentWallet.TxnType;
import com.machineCode.paymentWallet.account.UserWalletDao;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author anju
 * @created on 07/01/25 and 12:23 PM
 */
public class Transaction {
    BigDecimal amount;
    TxnType type;
    Date date;
    UserWalletDao partner;

    public Transaction(BigDecimal amount, TxnType type, Date date, UserWalletDao receiver) {
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.partner = receiver;
    }
}
