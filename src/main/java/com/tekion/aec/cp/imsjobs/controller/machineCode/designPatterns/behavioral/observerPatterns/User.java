package com.tekion.aec.cp.imsjobs.controller.machineCode.designPatterns.behavioral.observerPatterns;

/**
 * @author anju
 * @created on 12/02/25 and 1:00 PM
 */
public class User implements Observer {

    String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void receiveUpdate(){
        System.out.println("count has been updated for "+ this.name);
    }
}
