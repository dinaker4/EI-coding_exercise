# Decorator Pattern Demo

This project demonstrates the use of the Decorator Design Pattern in Java to dynamically add additional functionality to an object.

## Overview

The Decorator Pattern is a structural design pattern that allows behavior to be added to an individual object, dynamically, without affecting the behavior of other objects from the same class. This pattern is useful for adhering to the Open/Closed Principle, which states that classes should be open for extension but closed for modification.

In this example, we have a `Coffee` interface that defines the structure of a coffee object, and various decorators that add additional features (milk, sugar, whip) to a simple coffee.

## Components

1. **Coffee (Interface)**: 
   - Defines the methods to get the cost and description of the coffee.

2. **SimpleCoffee (Concrete Component)**: 
   - Implements the `Coffee` interface with a base cost and description.

3. **CoffeeDecorator (Abstract Decorator)**: 
   - Implements the `Coffee` interface and contains a reference to a `Coffee` object. It delegates the calls to the wrapped object.

4. **Milk, Sugar, Whip (Concrete Decorators)**: 
   - Extend `CoffeeDecorator` and override the `getCost` and `getDescription` methods to add additional behavior.

5. **DecoratorPatternDemo**: 
   - Contains the main method to demonstrate the pattern by creating and using decorated coffee objects.

## How it Works

1. The `SimpleCoffee` class implements the `Coffee` interface and provides the base implementation for cost and description.
2. The `CoffeeDecorator` class implements the `Coffee` interface and wraps a `Coffee` object. It forwards the method calls to the wrapped object.
3. The concrete decorators (`Milk`, `Sugar`, `Whip`) extend `CoffeeDecorator` and enhance the behavior of the `getCost` and `getDescription` methods.
4. The main method in `DecoratorPatternDemo` demonstrates how different combinations of decorators can be applied to the coffee.

## Usage

To run the demonstration:

1. Compile the Java files:
    ```sh
    javac DecoratorPatternDemo.java
    ```
2. Run the main class:
    ```sh
    java DecoratorPatternDemo
    ```

## Example Output
Simple Coffee costs $2.0
Simple Coffee, Milk costs $2.5
Simple Coffee, Milk, Sugar costs $2.7
Simple Coffee, Milk, Sugar, Whip costs $3.4
