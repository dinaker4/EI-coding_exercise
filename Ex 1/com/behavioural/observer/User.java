package com.behavioural.observer;

public class User implements NotificationObserver {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String post) {
        System.out.println(name + " received notification: New post - '" + post + "'");
    }
}