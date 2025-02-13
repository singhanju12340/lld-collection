package com.tekion.aec.cp.imsjobs.controller.machineCode.loggerSystem.message;

/**
 * @author anju
 * @created on 01/02/25 and 11:32 AM
 */
public interface LogServiceInterface {
    public  void info(String message);
    public void debug(String message);
    public void warn(String message);


}
