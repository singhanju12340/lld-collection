package com.machineCode.loggerSystem.model;

/**
 * @author anju
 * @created on 01/02/25 and 10:45 AM
 */
public enum LogLevel {
    DEBUG("DEBUG",1),
    INFO("INFO",2),
    WARN("WARN",3),
    ERROR("ERROR",4);

    String levelName;
    Integer order;


    public String getLevelName() {
        return levelName;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    LogLevel(String info, int order) {
        this.levelName = info;
        this.order = order;
    }


}
