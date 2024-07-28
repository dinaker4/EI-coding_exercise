package com.astronautscheduler.manager;

import com.astronautscheduler.model.Priority;
import com.astronautscheduler.model.Task;
import com.astronautscheduler.observer.TaskObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * Singleton class managing the astronaut's schedule.
 */
public class ScheduleManager {
    private static final Logger LOGGER = Logger.getLogger(ScheduleManager.class.getName());
    private static ScheduleManager instance;
    private List<Task> tasks;
    private List<TaskObserver> observers;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    /**
     * Returns the singleton instance of ScheduleManager.
     *
     * @return The single instance of ScheduleManager.
     */
    public static synchronized ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    /**
     * Adds a new task to the schedule.
     *
     * @param task The task to be added.
     * @throws IllegalArgumentException If the task conflicts with an existing task.
     */
    public void addTask(Task task) throws IllegalArgumentException {
        if (!task.isValidTask()){
            throw new IllegalArgumentException("Invalid task details - Start time cannot be after end time");
        }
        if (isTaskConflicting(task)) {
            throw new IllegalArgumentException("Task conflicts with an existing task.");
        }
        tasks.add(task);
        Collections.sort(tasks, (t1, t2) -> t1.getStartTime().compareTo(t2.getStartTime()));
        notifyObservers("Task added: " + task);
        LOGGER.info("Task added: " + task);
    }

    /**
     * Removes a task based on its ID.
     *
     * @param id The ID of the task to be removed.
     * @throws IllegalArgumentException If the task is not found.
     */
    public void removeTask(String id) {
        Task taskToRemove = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            notifyObservers("Task removed: " + taskToRemove);
            LOGGER.info("Task removed: " + taskToRemove);
        } else {
            throw new IllegalArgumentException("Task not found with ID: " + id);
        }
    }

    /**
     * Returns a list of all tasks.
     *
     * @return List of all tasks.
     */
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    /**
     * Returns a list of tasks filtered by priority.
     *
     * @param priority The priority level to filter by.
     * @return List of tasks with the specified priority.
     */
    public List<Task> getTasksByPriority(Priority priority) {
        return tasks.stream()
                .filter(t -> t.getPriority() == priority)
                .toList();
    }

    /**
     * Edits an existing task based on its ID.
     *
     * @param id         The ID of the task to be edited.
     * @param updatedTask The updated task details.
     * @throws IllegalArgumentException If the task is not found or conflicts with an existing task.
     */
    public void editTask(String id, Task updatedTask) {
        Task taskToEdit = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (taskToEdit != null) {
            if(!updatedTask.isValidTask()){
                throw new IllegalArgumentException("Invalid task details - Start time cannot be after end time");
            }
            if (isTaskConflicting(updatedTask) && !taskToEdit.equals(updatedTask)) {
                throw new IllegalArgumentException("Updated task conflicts with an existing task.");
            }
            int index = tasks.indexOf(taskToEdit);
            tasks.set(index, updatedTask);
            Collections.sort(tasks, (t1, t2) -> t1.getStartTime().compareTo(t2.getStartTime()));
            notifyObservers("Task updated: " + updatedTask);
            LOGGER.info("Task updated: " + updatedTask);
        } else {
            throw new IllegalArgumentException("Task not found with ID: " + id);
        }
    }

    /**
     * Marks a task as completed based on its ID.
     *
     * @param id The ID of the task to be marked as completed.
     * @throws IllegalArgumentException If the task is not found.
     */
    public void markTaskAsCompleted(String id) {
        Task task = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (task != null) {
            task.markAsCompleted();
            notifyObservers("Task marked as completed: " + task);
            LOGGER.info("Task marked as completed: " + task);
        } else {
            throw new IllegalArgumentException("Task not found with ID: " + id);
        }
    }

    /**
     * Checks if a new task conflicts with any existing tasks.
     *
     * @param newTask The new task to check for conflicts.
     * @return True if there is a conflict, otherwise false.
     */
    private boolean isTaskConflicting(Task newTask) {
        return tasks.stream().anyMatch(existingTask ->
                (newTask.getStartTime().isBefore(existingTask.getEndTime()) &&
                 newTask.getEndTime().isAfter(existingTask.getStartTime())) ||
                (newTask.getStartTime().equals(existingTask.getStartTime()) &&
                 newTask.getEndTime().equals(existingTask.getEndTime()))
        );
    }



    /**
     * Adds an observer to the list of observers.
     *
     * @param observer The observer to be added.
     */
    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from the list of observers.
     *
     * @param observer The observer to be removed.
     */
    public void removeObserver(TaskObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all observers with the given message.
     *
     * @param message The message to be sent to observers.
     */
    private void notifyObservers(String message) {
        for (TaskObserver observer : observers) {
            observer.update(message);
        }
    }
}
