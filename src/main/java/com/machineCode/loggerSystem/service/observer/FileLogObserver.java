package com.machineCode.loggerSystem.service.observer;

import com.machineCode.loggerSystem.exception.CustomLoggerException;
import com.machineCode.loggerSystem.utils.ErrorCode;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author anju
 * @created on 24/04/25 and 8:26 PM
 */
public class FileLogObserver implements LogObserver{
    private final String filePath;
    private final BlockingQueue<String> buffer = new LinkedBlockingQueue<>();
    private volatile boolean running = true;

    public FileLogObserver(String filePath) {
        this.filePath = filePath;
        startWriterThread();
    }

    private void startWriterThread() {
        new Thread(() -> {
            try (var writer = new java.io.FileWriter(filePath, true)) {
                while (running || !buffer.isEmpty()) {
                    String message = buffer.poll(100, TimeUnit.MILLISECONDS);
                    if (message != null) {
                        writer.write(message + "\n");
                    }
                }
            } catch (Exception e) {
                new CustomLoggerException(ErrorCode.ERROR_CODE_100, "Failed to create file log appender");
            }
        }).start();
    }

    @Override
    public void log(String message) {
//        buffer.offer(message);
        System.out.println("File Log: " + message);
    }

    public void shutdown() {
        running = false;
    }
}
