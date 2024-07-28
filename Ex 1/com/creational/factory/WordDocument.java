package com.creational.factory;

public class WordDocument implements Document {
    @Override
    public String create() {
        return "Creating Word document";
    }
}