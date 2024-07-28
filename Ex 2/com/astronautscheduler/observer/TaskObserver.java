package com.astronautscheduler.observer;

/**
 * Observer interface for task-related updates.
 */
public interface TaskObserver {
    void update(String message);
}
