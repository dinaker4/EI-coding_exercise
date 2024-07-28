package com.creational.factory;

public class ExcelFactory extends DocumentFactory {
    @Override
    Document createDocument() {
        return new ExcelDocument();
    }
}