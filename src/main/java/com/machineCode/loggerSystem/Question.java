package com.machineCode.loggerSystem;

/**
 * @author anju
 * @created on 01/02/25 and 10:36 AM
 */
public class Question {

    /***
     * Problem Statement:
     * You have to design and implement a logger library that applications can use to log messages.
     * Client/application make use of your logger library to log messages to a sink
     *
     *
     * Platform Capabilities:
     *
     * Message
     * has content which is of type string
     * has a level associated with it
     * has namespace associated with it to identify the part of application that sent the message
     * Sink
     * This is the destination for a message (e g text file, database, console, etc)
     * Sink is tied to one or more message level
     * Logger library
     * Requires configuration during sink setup
     * Accepts messages from client(s)
     * Routes messages to appropriate sink based on the level
     * Supports following message level in the order of priority: FATAL, ERROR WARN, INFO, DEBUG.
     * Message levels with higher priority above a given message level should be logged.
     * Ex: If INFO is configured as a message level, FATAL, ERROR, WARN and INFO should be logged
     * Enriches message with additional information (like timestamp) while directing message to a sink
     * Should not impact the client’s application flow. Eg - file sink based log should not increase the latency of calling function.
     * Sending messages
     * Sink need not be mentioned while sending a message to the logger library.
     * A message level has a 1:1 mapping with sink.
     * Client specifies message content, level and namespace while sending a message
     *
     *
     * Logger configuration (see sample below)
     * Specifies all the details required to use the logger library.
     * One configuration per association of message level and sink
     * You may consider logger configuration as a key-value pair
     * Example:
     * logging level
     * sink type
     * details required for sink (eg file location)
     *
     *
     * Bonus Capabilities:
     * No information loss. Logger library should log all the messages before the client application shuts down.
     * Log Level for the application can be updated dynamically.
     *
     *
     *
     *
     *
     * Commands:
     * Command to set logging level for application -
     * Command: SET_LOG_LEVEL <log-level>
     *
     *
     * Command to add a config -
     * Command: ADD_CONFIG <log-level> <sink-type> <sink-location [optional]>
     *
     *
     * Command to log a message
     *
     *
     * Command : LOG_MESSAGE <log-level> <message> <namespace>
     * Output : <sink-type> <level> <timestamp> <message> <namespace>
     *
     *
     *
     *
     *
     * Test Cases:
     * This doesn’t have to be a command line interface, you have to expose an equivalent function to execute the following scenarios. Eg - func info(args…), func debug(args…)
     *
     *
     * Command : ADD_CONFIG  INFO CONSOLE
     * Output : NA
     *
     * Command : ADD_CONFIG ERROR FILE
     * Output : NA
     *
     *
     * Command : ADD_CONFIG DEBUG FILE
     *
     *
     */
}
