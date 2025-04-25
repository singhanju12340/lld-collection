package com.machineCode.loggerSystem.utils;

import lombok.Data;

/**
 * @author anju
 * @created on 25/04/25 and 3:12 PM
 */

@Data
public class AppenderConfig {
    private String name;
    private String type;
    private String filePath;
}
