package com.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        SocialMediaPlatform platform = new SocialMediaPlatform();
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        platform.attach(user1);
        platform.attach(user2);

        platform.addPost("Hello, world!");
    }
}