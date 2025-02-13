package com.machineCode.loggerSystem.sink;

/**
 * @author anju
 * @created on 01/02/25 and 10:53 AM
 */
public interface SinkProcessor {

    public void add(String message);
    public void clear();
    public void close();

}
