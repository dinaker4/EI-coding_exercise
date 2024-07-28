package com.astronautscheduler.model;

import java.time.LocalTime;
import java.util.Objects;

/**
 * Represents a task with an ID, description, start time, end time, priority, and completion status.
 */
public class Task {
    private final String id;
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private Priority priority;
    private boolean isCompleted;

    /**
     * Constructor for Task.
     *
     * @param id Unique identifier for the task.
     * @param description Description of the task.
     * @param startTime Start time of the task.
     * @param endTime End time of the task.
     * @param priority Priority level of the task.
     */
    public Task(String id, String description, LocalTime startTime, LocalTime endTime, Priority priority) {
        this.id = id;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.isCompleted = false;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    /**
     * Marks the task as completed.
     */
    public void markAsCompleted() {
        this.isCompleted = true;
    }

    public boolean isValidTask(){
        return this.startTime.isBefore(this.endTime);
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s %s [%s] %s",
            startTime, endTime, id, description, priority, isCompleted ? "(Completed)" : "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

}
