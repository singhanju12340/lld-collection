package com.machineCode.loggerSystem;

import com.machineCode.loggerSystem.message.LogLevel;
import com.machineCode.loggerSystem.sink.DBSinkFactory;
import com.machineCode.loggerSystem.sink.DBSinkStore;
import com.machineCode.loggerSystem.sink.SinkProcessor;
import com.machineCode.loggerSystem.test.LoggerSettingConstant;

import java.util.*;

/**
 * @author anju
 * @created on 01/02/25 and 10:41 AM
 */
public class LogConfigurationBase {



    private static Set<String> allowedLevel = new HashSet<>(); // derived  fields
    private static String  sinkType;
    private static String serviceName;
    private static SinkProcessor sinkProcessor;


    private static LogConfigurationBase configurationBase;

    public static LogConfigurationBase getInstance(){
        if(configurationBase == null)
        {
            configurationBase = new LogConfigurationBase();  // it will read from file and get all the values
            setLoggerSetting();
        }
        return configurationBase;
    }

    private static void setLoggerSetting(){
        setAllowedLevel(LoggerSettingConstant.logLevel); // set allowed level for given level
        sinkType = LoggerSettingConstant.sinkType;
        serviceName = LoggerSettingConstant.serviceNameSpace;
        sinkProcessor = DBSinkFactory.getDBSinkInstance(sinkType); DBSinkStore.getInstance(); // can add switch case to select sink processer
    }



    // return all log of current level
    private static List<LogLevel> getAllLogByOrder(String currentLevel){
        Integer currentOrder = LogLevel.valueOf(currentLevel).getOrder(); // get current level

        List<LogLevel> result = new ArrayList<>();
        for (LogLevel logLevel: LogLevel.values()) {
            if(logLevel.getOrder()>=currentOrder)
                result.add(logLevel);
        }
        return result;
    }

    public static void setAllowedLevel(String level){
        List<LogLevel> levels =  getAllLogByOrder(level);
        if(levels.isEmpty()){
            throw new CustomLoggerException("No logger level defined, please add valid logger level in file");
        }

        for (LogLevel currLevel: levels) {
            allowedLevel.add(currLevel.getLevelName());
        }
    }


    // public interfaces
    public Set<String> getAllowedLevel(){
        return allowedLevel;
    }

    public SinkProcessor getSinkProcessor(){
        return sinkProcessor;
    }

    public String getServiceName(){
        return serviceName;
    }



}
