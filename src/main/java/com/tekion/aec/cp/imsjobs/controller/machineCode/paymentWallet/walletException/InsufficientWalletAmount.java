package com.tekion.aec.cp.imsjobs.controller.machineCode.paymentWallet.walletException;

/**
 * @author anju
 * @created on 07/01/25 and 4:59 PM
 */
public class InsufficientWalletAmount extends  RuntimeException{
    public InsufficientWalletAmount(String s) {
        super(s);
    }
}
