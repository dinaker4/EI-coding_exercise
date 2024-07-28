# Social Media Notification System

This project demonstrates the implementation of the Observer Pattern in Java, showcasing a simple social media notification system.

## Overview

The Observer Pattern is a behavioral design pattern that allows objects (observers) to be notified automatically of any state changes in another object (subject) without tightly coupling the objects together. In this example, we've applied the Observer Pattern to create a basic social media platform where users (observers) receive notifications when new posts are added to the platform (subject).

## Components

1. `NotificationObserver` (Interface): Defines the update method for observers.
2. `SocialMediaPlatform` (Subject): Manages observers and notifies them of new posts.
3. `User` (Concrete Observer): Represents users who receive notifications.
4. `ObserverPatternDemo`: Contains the main method to demonstrate the pattern.

## How it Works

1. Users (observers) can be attached to or detached from the SocialMediaPlatform.
2. When a new post is added to the platform, all attached users are notified.
3. Each user receives the notification and processes it (in this case, by printing a message).

## Usage

To run the demonstration:

1. Compile the Java files:
2. Run the main class:

## Example Output
Alice received notification: New post - 'Hello, world!'
Bob received notification: New post - 'Hello, world!'