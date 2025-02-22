package com.machineCode.ATM;

/**
 * @author anju
 * @created on 13/02/25 and 3:21 PM
 */
public class Card {
    private String cardNo;
    private String expiry;
    private String pin;

    public Card(String cardNo, String expiry, String pin) {
        this.cardNo = cardNo;
        this.expiry = expiry;
        this.pin = pin;
    }
}
