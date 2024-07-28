package com.creational.single;

public class SingletonPatternDemo {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println(logger1 == logger2);  // Should print: true

        logger1.log("This is a log message");
        System.out.println(logger2.getLogFile());
    }
}