package com.tekion.aec.cp.imsjobs.controller.machineCode.paymentWallet.account;

import com.tekion.aec.cp.imsjobs.controller.machineCode.paymentWallet.wallet.Transaction;
import com.tekion.aec.cp.imsjobs.controller.machineCode.paymentWallet.wallet.WalletDao;
import com.tekion.aec.cp.imsjobs.controller.machineCode.paymentWallet.walletException.InsufficientWalletAmount;
import com.tekion.aec.cp.imsjobs.controller.machineCode.stockExchange.model.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.tekion.aec.cp.imsjobs.controller.machineCode.paymentWallet.TxnType.ADD;
import static com.tekion.aec.cp.imsjobs.controller.machineCode.paymentWallet.TxnType.SUBS;

/**
 * @author anju
 * @created on 07/01/25 and 12:24 PM
 */
public class UserWalletDao implements UserWallet{
    WalletDao account;
    List<Transaction> transactions;
    User user;

    public UserWalletDao(User user) {
        this.transactions = new ArrayList<>();
        this.user = user;
    }

    @Override
    public void createWallet(WalletDao wallet) {
        // add authentication and KYC process
        this.account = wallet;
    }

    @Override
    public void fetchAllAccountBalance() {
            // not implemented
    }


    @Override
    public BigDecimal fetchAccountBalance() {
        // fetch balance for given wallet id
       return this.account.getBalance();
    }



    @Override
    public void fetchAllTxn(WalletDao wallet, Integer limit) {
        // not implemented
    }

    @Override
    public void fetchTxnCountOfMonth(WalletDao wallet) {
        // not implemented
    }

    @Override
    public boolean validateTxn(BigDecimal amount) {
        // check if current wallet have balance>= amount
        if(account.getBalance().compareTo(amount) <0)
            throw  new InsufficientWalletAmount("Wallet balance is insufficient");
        return true;
    }


    @Override
    public void addMoney(BigDecimal amount) {
        this.account.setBalance(this.account.getBalance().add(amount));

    }

    @Override
    public void sendMoney(UserWalletDao receiver, BigDecimal amount) {
        // validate sender wallet blance
        // deduct sender blance
        // add to receiver blance

        this.validateTxn(amount);
        this.account.setBalance( this.account.getBalance().subtract(amount));
        receiver.addMoney(amount);

        // update receiver txn
        receiver.transactions.add( new Transaction(amount, ADD, new Date(), this));
        // update sender txn
        this.transactions.add( new Transaction(amount, SUBS, new Date(), receiver));

    }


}
