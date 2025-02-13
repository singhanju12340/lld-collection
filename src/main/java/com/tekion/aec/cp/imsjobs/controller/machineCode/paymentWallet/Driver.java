package com.tekion.aec.cp.imsjobs.controller.machineCode.paymentWallet;

import com.tekion.aec.cp.imsjobs.controller.machineCode.paymentWallet.account.UserWalletDao;
import com.tekion.aec.cp.imsjobs.controller.machineCode.paymentWallet.wallet.WalletDao;
import com.tekion.aec.cp.imsjobs.controller.machineCode.stockExchange.model.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anju
 * @created on 07/01/25 and 12:38 PM
 */
public class Driver {

    public static void main(String[] args) {
        //create user wallet for user 1
        // create user wallet for user 2
        // add balance from bank to user 1
        // transfer amount from user 1 to user 2
        // fetch latest balance for user 1
        // fetch latest balance for user 2

        // fetch all txn for user1
        User user1 = new User();
        user1.setId("1");

        UserWalletDao user1Wallet = new UserWalletDao(user1);
        user1Wallet.createWallet(new WalletDao("1", "wallet user 1", "Food", new BigDecimal(100.00)));


        User user2 = new User();
        user2.setId("2");

        UserWalletDao user2Wallet = new UserWalletDao(user2);
        user2Wallet.createWallet(new WalletDao("2", "wallet user 2", "Food", new BigDecimal(200.00)));




        List<UserWalletDao> walletAccounts = new ArrayList<>();
        walletAccounts.add(user1Wallet);
        walletAccounts.add(user2Wallet);

        user2Wallet.sendMoney(user1Wallet, new BigDecimal(20.0));

        System.out.println(user2Wallet.fetchAccountBalance());
        System.out.println(user1Wallet.fetchAccountBalance());
    }
}
