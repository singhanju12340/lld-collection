package com.tekion.aec.cp.imsjobs.controller.machineCode.paymentWallet.wallet;

import java.math.BigDecimal;

/**
 * @author anju
 * @created on 07/01/25 and 12:49 PM
 */
public class WalletDaoImpl implements WalletService {
    WalletDao walletDao;

    @Override
    public void addBalance(BigDecimal balance) {
        this.walletDao.balance = this.walletDao.balance.add( balance);
    }

    @Override
    public void deductBalance(BigDecimal balance) {
        this.walletDao.balance = this.walletDao.balance.subtract( balance);

    }

    @Override
    public BigDecimal getBalance() {
        return this.walletDao.balance;
    }

    @Override
    public String getWalletId() {
        return this.walletDao.id;
    }
}
