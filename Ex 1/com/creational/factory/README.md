# Factory Method Pattern Demo

This project demonstrates the use of the Factory Method Design Pattern in Java to create different types of documents (PDF, Word, Excel).

## Overview

The Factory Method Pattern defines an interface for creating an object but allows subclasses to alter the type of objects that will be created. This pattern lets a class defer instantiation to subclasses.

In this example, we have different types of documents (PDF, Word, Excel) that can be created using specific factories.

## Components

1. **Document (Interface)**: Defines the method for creating a document.
2. **PDFDocument, WordDocument, ExcelDocument (Concrete Products)**: Implement the `Document` interface for different document types.
3. **DocumentFactory (Abstract Factory)**: Declares the factory method that returns an object of type `Document`.
4. **PDFFactory, WordFactory, ExcelFactory (Concrete Factories)**: Implement the `DocumentFactory` and create specific document types.
5. **FactoryMethodPatternDemo**: Contains the main method to demonstrate the pattern.

## How it Works

1. Each concrete factory (PDFFactory, WordFactory, ExcelFactory) overrides the `createDocument` method to instantiate a specific document type.
2. The main method in `FactoryMethodPatternDemo` creates instances of each factory and calls their `createDocument` method to create and display the document type.

## Usage

To run the demonstration:

1. Compile the Java files:
    ```sh
    javac FactoryMethodPatternDemo.java
    ```
2. Run the main class:
    ```sh
    java FactoryMethodPatternDemo
    ```

## Example Output
Creating PDF document
Creating Word document
Creating Excel document
