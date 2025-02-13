package com.tekion.aec.cp.imsjobs.controller.machineCode.designPatterns.behavioral.observerPatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anju
 * @created on 12/02/25 and 1:00 PM
 */
public class ShopManager<T extends Observer>{

    int phoneCount;

    List<T> subscribers;


    public int getPhoneCount() {
        return phoneCount;
    }

    public void setPhoneCount(int phoneCount) {
        this.phoneCount = phoneCount;
        notifyAvailability();
    }

    void subscribe(List<T> subscribers){
        if(this.subscribers == null)
            this.subscribers = new ArrayList<>();

            this.subscribers.addAll(subscribers);
     }

    void remove(T subscriber){
        if(subscribers == null)
            this.subscribers.remove(subscriber);
    }

    public void notifyAvailability(){
        for (T listner: subscribers) {
            listner.receiveUpdate();
        }
    }

}
