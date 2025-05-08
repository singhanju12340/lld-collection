package com.machineCode.loggerSystem.service.observer;

import com.machineCode.loggerSystem.exception.CustomLoggerException;
import com.machineCode.loggerSystem.service.logPattern.Pattern;
import com.machineCode.loggerSystem.utils.ErrorCode;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.concurrent.*;

/**
 * @author anju
 * @created on 24/04/25 and 8:26 PM
 */
public class FileLogAyncAppender implements LogAppender {
    private final String filePath;
    private final BlockingQueue<String> buffer = new LinkedBlockingQueue<>();
    private volatile boolean running = true;
    private final Pattern pattern;
    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public FileLogAyncAppender(String filePath,Pattern pattern) {
        this.filePath = filePath;
        this.pattern = pattern;
        startWriterThread();
    }

    private void startWriterThread() {
        synchronized (this){
            executorService.submit(() -> {
                try {
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true)));
                    while (running || !buffer.isEmpty()) {
                        String message = buffer.poll(100, TimeUnit.SECONDS);
                        if (message != null) {
                            writer.write(message + "\n");
                            writer.flush();
                        }
                    }
                } catch (Exception e) {
                    new CustomLoggerException(ErrorCode.ERROR_CODE_100, "Failed to create file log appender");
                }
            });
        }
    }

    @Override
    public void append(String message) {
        boolean result = buffer.offer(message);
        if (!result) {
            // Emergency sync write if queue full
            emergencyWrite(message);
        }
        System.out.println("File Log: " + pattern.format(message));
    }


    private synchronized void emergencyWrite(String message) {
        System.out.println("emergency write");
    }


    public void shutdown() {
        running = false;
        executorService.shutdown();

    }
}
