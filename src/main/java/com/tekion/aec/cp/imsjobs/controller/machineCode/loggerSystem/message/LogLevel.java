package com.tekion.aec.cp.imsjobs.controller.machineCode.loggerSystem.message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anju
 * @created on 01/02/25 and 10:45 AM
 */
public enum LogLevel {
    INFO("INFO",2),
    DEBUG("DEBUG",1),
    WARN("WARN",3),
    ERROR("ERROR",4);


    String levelName;
    Integer order;


    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
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
