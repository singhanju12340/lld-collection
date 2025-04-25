package com.machineCode.loggerSystem.service;

/**
 * @author anju
 * @created on 01/02/25 and 11:32 AM
 */
public interface LogService {
    public  void info(String message);
    public void debug(String message);
    public void warn(String message);
    public void error(String message);

}
