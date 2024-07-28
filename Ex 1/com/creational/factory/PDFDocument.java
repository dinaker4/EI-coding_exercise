package com.creational.factory;

public class PDFDocument implements Document {
    @Override
    public String create() {
        return "Creating PDF document";
    }
}