package com.astronautscheduler.controller;

import com.astronautscheduler.factory.TaskFactory;
import com.astronautscheduler.manager.ScheduleManager;
import com.astronautscheduler.model.Priority;
import com.astronautscheduler.model.Task;
import com.astronautscheduler.view.ConsoleView;

import java.util.List;

/**
 * Controller class managing user interactions and business logic.
 */
public class ScheduleController {
    private final ScheduleManager scheduleManager;
    private final ConsoleView view;

    public ScheduleController(ConsoleView view) {
        this.scheduleManager = ScheduleManager.getInstance();
        this.view = view;
        scheduleManager.addObserver(view);
    }

    public void run() {
        while (true) {
            String choice = view.showMenu();
            switch (choice) {
                case "1" -> addTask();
                case "2" -> removeTask();
                case "3" -> viewAllTasks();
                case "4" -> editTask();
                case "5" -> markTaskAsCompleted();
                case "6" -> viewTasksByPriority();
                case "7" -> {
                    view.displayMessage("Exiting the application. Goodbye!");
                    return;
                }
                default -> view.displayError("Invalid choice. Please try again.");
            }
        }
    }

    private void addTask() {
        try {
            String description = view.getInput("Enter task description: ");
            String startTime = view.getInput("Enter start time (HH:mm): ");
            String endTime = view.getInput("Enter end time (HH:mm): ");
            String priority = view.getInput("Enter priority (LOW/MEDIUM/HIGH): ");
            
            Task task = TaskFactory.createTask(description, startTime, endTime, priority);
            scheduleManager.addTask(task);
            view.displayMessage("Task added successfully.");
        } catch (Exception e) {
            view.displayError("Error adding task: " + e.getMessage());
        }
    }

    private void removeTask() {
        try {
            String description = view.getInput("Enter task description to remove: ");
            scheduleManager.removeTask(description);
            view.displayMessage("Task removed successfully.");
        } catch (Exception e) {
            view.displayError("Error removing task: " + e.getMessage());
        }
    }

    private void viewAllTasks() {
        List<Task> tasks = scheduleManager.getAllTasks();
        if (tasks.isEmpty()) {
            view.displayMessage("No tasks scheduled for the day.");
        } else {
            view.displayTasks(tasks);
        }
    }

    private void editTask() {
        try {
            String description = view.getInput("Enter task description to edit: ");
            String newDescription = view.getInput("Enter new description: ");
            String newStartTime = view.getInput("Enter new start time (HH:mm): ");
            String newEndTime = view.getInput("Enter new end time (HH:mm): ");
            String newPriority = view.getInput("Enter new priority (LOW/MEDIUM/HIGH): ");
            
            Task updatedTask = TaskFactory.createTask(newDescription, newStartTime, newEndTime, newPriority);
            scheduleManager.editTask(description, updatedTask);
            view.displayMessage("Task updated successfully.");
        } catch (Exception e) {
            view.displayError("Error editing task: " + e.getMessage());
        }
    }

    private void markTaskAsCompleted() {
        try {
            String description = view.getInput("Enter task description to mark as completed: ");
            scheduleManager.markTaskAsCompleted(description);
            view.displayMessage("Task marked as completed successfully.");
        } catch (Exception e) {
            view.displayError("Error marking task as completed: " + e.getMessage());
        }
    }

    private void viewTasksByPriority() {
        try {
            String priority = view.getInput("Enter priority level to view tasks (LOW/MEDIUM/HIGH): ");
            List<Task> tasks = scheduleManager.getTasksByPriority(Priority.valueOf(priority.toUpperCase()));
            if (tasks.isEmpty()) {
                view.displayMessage("No tasks found for the specified priority level.");
            } else {
                view.displayTasks(tasks);
            }
        } catch (Exception e) {
            view.displayError("Error viewing tasks by priority: " + e.getMessage());
        }
    }
}
