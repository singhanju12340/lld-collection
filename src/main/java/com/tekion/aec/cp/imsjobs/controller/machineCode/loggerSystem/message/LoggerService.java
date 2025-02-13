package com.tekion.aec.cp.imsjobs.controller.machineCode.loggerSystem.message;

import com.tekion.aec.cp.imsjobs.controller.machineCode.loggerSystem.LogConfigurationBase;
import com.tekion.aec.cp.imsjobs.controller.machineCode.loggerSystem.sink.SinkProcessor;
import com.tekion.aec.cp.imsjobs.controller.machineCode.loggerSystem.test.LoggerSettingConstant;

import java.time.Instant;

/**
 * @author anju
 * @created on 01/02/25 and 11:02 AM
 */
public class LoggerService implements LogServiceInterface{



    private static void logEntry(String logLevel, String logMessage){


        if( LogConfigurationBase.getInstance().getAllowedLevel().contains(logLevel)){
            LogConfigurationBase.getInstance().getSinkProcessor().add(messageBeautifer(logMessage));
        }
        else
        {
            // just ignore message added only for debugging purposes
        }
    }

    private static String messageBeautifer(String message){
        StringBuilder builder = new StringBuilder();
        builder.append(LogConfigurationBase.getInstance().getServiceName() + ":"+ Instant.now() + " : " + message);
        return builder.toString();
    }


    @Override
    public void info(String message) {
        logEntry(LogLevel.INFO.levelName, message);
    }

    @Override
    public void debug(String message) {
        logEntry(LogLevel.DEBUG.levelName, message);

    }

    @Override
    public void warn(String message) {
        logEntry(LogLevel.WARN.levelName, message);
    }
}
