package com.creational.factory;

public class ExcelDocument implements Document {
    @Override
    public String create() {
        return "Creating Excel document";
    }
}