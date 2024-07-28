package com.astronautscheduler;

import com.astronautscheduler.controller.ScheduleController;
import com.astronautscheduler.manager.LoggingConfig;
import com.astronautscheduler.view.ConsoleView;

/**
 * Main entry point for the Astronaut Daily Schedule Organizer application.
 */
public class Main {
    public static void main(String[] args) {
        LoggingConfig.setupLogger();
        ConsoleView view = ConsoleView.getInstance();
        ScheduleController controller = new ScheduleController(view);
        controller.run();
    }
}








