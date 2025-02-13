package com.tekion.aec.cp.imsjobs.controller.machineCode.paymentWallet.wallet;

import java.math.BigDecimal;

/**
 * @author anju
 * @created on 07/01/25 and 12:17 PM
 */
public interface WalletService {

    void addBalance(BigDecimal balance);

    void deductBalance(BigDecimal balance);

    BigDecimal getBalance();

    String getWalletId();




}
