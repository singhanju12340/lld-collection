package com.machineCode.loggerSystem.test;

import com.machineCode.loggerSystem.service.BaseLogger;
import com.machineCode.loggerSystem.service.impl.Logger;


/**
 * @author anju
 * @created on 01/02/25 and 11:14 AM
 */
public class LogExecutor {

    public void testInfo(){

    }

    public void testDebug(){

    }



    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

//        BaseLogger.level = 2;


        logger.info("info  mesasge");
        logger.debug("debug mesasge");

        logger.warn("warning mesasge");

        // update log level dynamically. as it is stored in memory we can run resync job to update it from cache  to load dynamically
//        BaseLogger.level = 1;

        logger.info("after debug set up, info mesasge");

        logger.debug("after debug set up, debug mesasge");

        logger.warn("after warn set up, warning mesasge");
        logger.error("after warn set up, error mesasge");


    }



}
