package com.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class SocialMediaPlatform {
    private List<NotificationObserver> observers = new ArrayList<>();
    private String latestPost;

    public void attach(NotificationObserver observer) {
        observers.add(observer);
    }

    public void detach(NotificationObserver observer) {
        observers.remove(observer);
    }

    public void notify(String post) {
        this.latestPost = post;
        for (NotificationObserver observer : observers) {
            observer.update(post);
        }
    }

    public void addPost(String post) {
        notify(post);
    }
}