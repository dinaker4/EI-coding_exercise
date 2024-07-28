# Singleton Pattern Demo

This project demonstrates the use of the Singleton Design Pattern in Java to manage a single instance of a `Logger` class.

## Overview

The Singleton Pattern ensures that a class has only one instance and provides a global point of access to it. This pattern is useful when exactly one object is needed to coordinate actions across the system.

In this example, we have a `Logger` class that ensures only one instance is created and used throughout the application.

## Components

1. **Logger (Singleton Class)**: 
   - Ensures that only one instance of the class exists.
   - Provides a global point of access to the instance.
   - Contains a method to log messages and retrieve the log file name.

2. **SingletonPatternDemo**: 
   - Contains the main method to demonstrate the pattern by creating and using the singleton instance of `Logger`.

## How it Works

1. The `Logger` class has a private static variable to hold the single instance of the class.
2. The constructor of the `Logger` class is private to prevent instantiation from other classes.
3. The `getInstance` method checks if an instance already exists; if not, it creates one. This ensures only one instance is created.
4. The `log` method simulates logging a message to a log file.
5. The main method in `SingletonPatternDemo` demonstrates that only one instance of `Logger` is used.

## Usage

To run the demonstration:

1. Compile the Java files:
    ```sh
    javac SingletonPatternDemo.java
    ```
2. Run the main class:
    ```sh
    java SingletonPatternDemo
    ```

## Example Output

true
Logging to app.log: This is a log message
app.log