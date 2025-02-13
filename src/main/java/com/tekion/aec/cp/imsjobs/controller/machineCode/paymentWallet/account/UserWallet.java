package com.tekion.aec.cp.imsjobs.controller.machineCode.paymentWallet.account;

import com.tekion.aec.cp.imsjobs.controller.machineCode.paymentWallet.wallet.WalletDao;
import com.tekion.aec.cp.imsjobs.controller.machineCode.paymentWallet.wallet.WalletService;

import java.math.BigDecimal;

/**
 * @author anju
 * @created on 07/01/25 and 12:19 PM
 */
public interface UserWallet {

    void createWallet(WalletDao wallet);

    void fetchAllAccountBalance();

    BigDecimal fetchAccountBalance();

    void fetchAllTxn(WalletDao wallet, Integer limit);

    void fetchTxnCountOfMonth(WalletDao wallet);

    boolean validateTxn( BigDecimal amount);


    void addMoney(BigDecimal amount);

    void sendMoney(UserWalletDao walletDao, BigDecimal amount);


}
