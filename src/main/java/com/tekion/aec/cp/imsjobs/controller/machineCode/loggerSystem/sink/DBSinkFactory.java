package com.tekion.aec.cp.imsjobs.controller.machineCode.loggerSystem.sink;

/**
 * @author anju
 * @created on 01/02/25 and 12:51 PM
 */
public class DBSinkFactory {

    public static SinkProcessor getDBSinkInstance(String sinkType){

        switch (sinkType){
            case "DB" :
                return new DBSinkStore();
            case "FILE":
                return new FileSinkProcessor();
            case "CONSOLE":
                return new ConsoleSinkFactory();
            default:
                return new ConsoleSinkFactory();
        }
    }


}
