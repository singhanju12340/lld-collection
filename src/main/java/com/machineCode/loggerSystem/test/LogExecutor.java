package com.machineCode.loggerSystem.test;

import com.machineCode.loggerSystem.LogConfigurationBase;
import com.machineCode.loggerSystem.message.LoggerService;

import static com.machineCode.loggerSystem.LogConfigurationBase.setAllowedLevel;

/**
 * @author anju
 * @created on 01/02/25 and 11:14 AM
 */
public class LogExecutor {
    static LoggerService log;

    public void testInfo(){

    }

    public void testDebug(){

    }



    public static void main(String[] args) {
        LogConfigurationBase logConfigurationBase = LogConfigurationBase.getInstance(); // setting up logger properties
        log = new LoggerService();

        log.info(null);


        log.debug("debug mesasge");

        log.warn("warning mesasge");

        // update log level dynamically. as it is stored in memory we can run resync job to update it from cache  to load dynamically
        LoggerSettingConstant.logLevel = "DEBUG";
        // refresh log level from cache
        setAllowedLevel(LoggerSettingConstant.logLevel);

        log.info("after debug set up, info mesasge");

        log.debug("after debug set up, debug mesasge");

        log.warn("after debug set up, warning mesasge");

    }



}
