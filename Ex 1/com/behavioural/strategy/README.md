# Strategy Pattern Demo

This project demonstrates the use of the Strategy Design Pattern in Java to handle different payment methods in a shopping cart application.

## Overview

The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. This pattern allows the algorithm to vary independently from clients that use it.

In this example, we have a shopping cart that can use different payment strategies to process payments. The payment strategies implemented are Credit Card and PayPal.

## Components

1. **PaymentStrategy (Interface)**: Defines the interface for payment algorithms.
2. **CreditCardPayment (Concrete Strategy)**: Implements the `PaymentStrategy` interface for payments using a credit card.
3. **PayPalPayment (Concrete Strategy)**: Implements the `PaymentStrategy` interface for payments using PayPal.
4. **ShoppingCart (Context)**: Contains a list of items and uses a `PaymentStrategy` to process payments.
5. **Item**: Represents an item in the shopping cart.
6. **StrategyPatternDemo**: Contains the main method to demonstrate the pattern.

## How it Works

1. Items can be added to the `ShoppingCart`.
2. A payment strategy (Credit Card or PayPal) is set for the `ShoppingCart`.
3. When the `checkout` method is called, the total amount is calculated, and the selected payment strategy is used to process the payment.

## Usage

To run the demonstration:

1. Compile the Java files:
    ```sh
    javac StrategyPatternDemo.java
    ```
2. Run the main class:
    ```sh
    java StrategyPatternDemo
    ```

## Example Output

Paid $1020.0 using Credit Card: 1234-5678-9012-3456
Paid $1020.0 using PayPal account: user@example.com