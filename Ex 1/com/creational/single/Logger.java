package com.creational.single;

public class Logger {
    private static Logger instance;
    private String logFile;

    private Logger() {
        logFile = "app.log";
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        // In a real implementation, this would write to the log file
        System.out.println("Logging to " + logFile + ": " + message);
    }

    public String getLogFile() {
        return logFile;
    }
}