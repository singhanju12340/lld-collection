package com.machineCode.loggerSystem.service.chain;

import com.machineCode.loggerSystem.service.LogAppendHandler;

import static com.machineCode.loggerSystem.model.LogLevel.INFO;
import static com.machineCode.loggerSystem.service.LogDataManager.systemLevel;

/**
 * @author anju
 * @created on 26/04/25 and 6:37 PM
 */
public class InfoLogger extends BaseLogger{

   public InfoLogger() {
        this.level = INFO.getOrder();
    }

    @Override
    public  void write(Integer level, String message, LogAppendHandler logSinkHandler){
        logSinkHandler.notifyLogSinks(level,getLevelName(level)+" : "+message);
    }
}
