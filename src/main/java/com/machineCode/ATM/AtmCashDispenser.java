package com.machineCode.ATM;

/**
 * @author anju
 * @created on 15/02/25 and 8:46 PM
 */
public class AtmCashDispenser {
    private static double totalCashWithAtm=1000000;

    public static double getCashInAtm(){
        return totalCashWithAtm;
    }

    public static double debitCashInAtm(double amount){
        return totalCashWithAtm = totalCashWithAtm - amount;
    }

    public static double creditCashInAtm(double amount){
        return totalCashWithAtm = totalCashWithAtm+amount;
    }
}
