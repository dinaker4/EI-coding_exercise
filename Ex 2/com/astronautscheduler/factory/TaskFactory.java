package com.astronautscheduler.factory;

import com.astronautscheduler.model.Priority;
import com.astronautscheduler.model.Task;

import java.time.LocalTime;

/**
 * Factory class for creating Task objects.
 */
public class TaskFactory {
    public static int numTasks = 0;
    public static Task createTask(String description, String startTime, String endTime, String priority) {
        String id = Integer.toString(++numTasks);
        LocalTime start = LocalTime.parse(startTime);
        LocalTime end = LocalTime.parse(endTime);
        Priority taskPriority = Priority.valueOf(priority.toUpperCase());
        return new Task(id,description, start, end, taskPriority);
    }
}
