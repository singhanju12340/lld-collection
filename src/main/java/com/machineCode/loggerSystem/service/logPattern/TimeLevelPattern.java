package com.machineCode.loggerSystem.service.logPattern;

import lombok.Data;

import java.time.Instant;

/**
 * @author anju
 * @created on 25/04/25 and 4:06 PM
 */

@Data
public class TimeLevelPattern implements Pattern {

    @Override
    public String format( String message) {
        StringBuilder formattedMessage = new StringBuilder();
        formattedMessage.append(Instant.now().toString());
        formattedMessage.append(" : ");
        formattedMessage.append(message);
        return formattedMessage.toString();
    }
}
