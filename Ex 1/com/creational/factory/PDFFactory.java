package com.creational.factory;

public class PDFFactory extends DocumentFactory {
    @Override
    Document createDocument() {
        return new PDFDocument();
    }
}