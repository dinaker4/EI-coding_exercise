package com.astronautscheduler.view;

import com.astronautscheduler.model.Task;
import com.astronautscheduler.observer.TaskObserver;

import java.util.List;
import java.util.Scanner;

/**
 * Console-based view for user interaction.
 */
public class ConsoleView implements TaskObserver {
    private final Scanner scanner;
    private static ConsoleView instance;

    private ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public static synchronized ConsoleView getInstance(){
        if(instance==null){
            instance = new ConsoleView();
        }
        return instance;
    }

    public String showMenu() {
        System.out.println("\n===== Astronaut Daily Schedule Organizer =====");
        System.out.println("1. Add a new task");
        System.out.println("2. Remove a task");
        System.out.println("3. View all tasks");
        System.out.println("4. Edit a task");
        System.out.println("5. Mark a task as completed");
        System.out.println("6. View tasks by priority");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextLine();
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String error) {
        System.out.println("Error: " + error);
    }

    public void displayTasks(List<Task> tasks) {
        System.out.println("Scheduled tasks:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    @Override
    public void update(String message) {
        System.out.println("Update: " + message);
    }
}