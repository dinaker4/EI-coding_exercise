# Astronaut Daily Schedule Organizer

## Overview

The Astronaut Daily Schedule Organizer is a console-based Java application designed to help astronauts manage their daily tasks efficiently. It allows users to add, remove, edit, and view tasks, as well as mark them as completed. The application ensures that tasks do not overlap and provides a clear view of the day's schedule.

## Features

- Add new tasks with description, start time, end time, and priority level
- Remove existing tasks
- View all tasks sorted by start time
- Edit existing tasks
- Mark tasks as completed
- View tasks filtered by priority level
- Prevent task conflicts (overlapping time slots)
- Logging system for tracking application usage and errors

## Technical Details

The application is built using Java and follows SOLID principles and design patterns for maintainable and extensible code. Key design patterns used include:

- Singleton Pattern: For the ScheduleManager
- Factory Pattern: For creating Task objects
- Observer Pattern: For notifying about task updates

## Usage

Upon starting the application, you'll be presented with a menu:

1. Add a new task
2. Remove a task
3. View all tasks
4. Edit a task
5. Mark a task as completed
6. View tasks by priority
7. Exit

Follow the on-screen prompts to interact with the scheduler.

## Code Structure

- `com.astronautscheduler.model`: Contains the Task and Priority classes
- `com.astronautscheduler.factory`: Contains the TaskFactory for creating Task objects
- `com.astronautscheduler.manager`: Contains the ScheduleManager (Singleton)
- `com.astronautscheduler.controller`: Contains the ScheduleController
- `com.astronautscheduler.view`: Contains the ConsoleView
- `com.astronautscheduler.observer`: Contains the TaskObserver interface
- `com.astronautscheduler.util`: Contains the LoggerManager

## Logging

The application uses Java's built-in logging (java.util.logging) to log important events, user actions, and errors. Logs are written to both the console and a file named `astronaut_scheduler.log` in the application's root directory.

