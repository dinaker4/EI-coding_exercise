package com.astronautscheduler.manager;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Utility class to configure logging for the application.
 */
public class LoggingConfig {
    private static final Logger LOGGER = Logger.getLogger(ScheduleManager.class.getName());

    public static void setupLogger() {
        try {
            // Set up the file handler
            FileHandler fileHandler = new FileHandler("astronaut_scheduler.log", true);
            fileHandler.setFormatter(new SimpleFormatter());

            // Add the file handler to the logger
            LOGGER.addHandler(fileHandler);
            LOGGER.setUseParentHandlers(false); // Prevent duplicate logs on console
        } catch (IOException e) {
            System.err.println("Failed to initialize logger: " + e.getMessage());
        }
    }
}
