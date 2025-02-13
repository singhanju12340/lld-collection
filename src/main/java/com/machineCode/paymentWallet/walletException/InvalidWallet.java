package com.machineCode.paymentWallet.walletException;

/**
 * @author anju
 * @created on 07/01/25 and 12:57 PM
 */
public class InvalidWallet extends IllegalArgumentException{
    public InvalidWallet(String s) {
        super(s);
    }
}
