# Adapter Pattern Demo

This project demonstrates the use of the Adapter Design Pattern in Java to allow compatibility between a legacy data format and a modern data format interface.

## Overview

The Adapter Pattern is a structural design pattern that allows objects with incompatible interfaces to work together. This pattern involves a single class, called an adapter, which is responsible for joining functionalities of independent or incompatible interfaces.

In this example, we adapt a `LegacyDataFormat` class to the `ModernDataFormat` interface using a `DataAdapter`.

## Components

1. **LegacyDataFormat (Adaptee)**: 
   - Represents the existing class with a specific data format.
   - Contains a method to retrieve data in the legacy format.

2. **ModernDataFormat (Target Interface)**: 
   - Defines the interface that is expected by the modern system.

3. **DataAdapter (Adapter)**: 
   - Implements the `ModernDataFormat` interface.
   - Adapts the `LegacyDataFormat` to the `ModernDataFormat` by translating the data format.

4. **AdapterPatternDemo**: 
   - Contains the main method to demonstrate the pattern by creating and using the adapter.

## How it Works

1. The `LegacyDataFormat` class has a method `getLegacyData` that returns data in the legacy format.
2. The `ModernDataFormat` interface defines a method `getModernData` that the modern system expects.
3. The `DataAdapter` class implements the `ModernDataFormat` interface and holds an instance of `LegacyDataFormat`.
4. The `getModernData` method in `DataAdapter` translates the legacy data to the modern format.
5. The main method in `AdapterPatternDemo` demonstrates how the `DataAdapter` allows the legacy data to be used in the modern system.

## Usage

To run the demonstration:

1. Compile the Java files:
    ```sh
    javac AdapterPatternDemo.java
    ```
2. Run the main class:
    ```sh
    java AdapterPatternDemo
    ```

## Example Output

Modern Data: Important information