package com.creational.factory;

public class FactoryMethodPatternDemo {
    public static void main(String[] args) {
        DocumentFactory pdfFactory = new PDFFactory();
        DocumentFactory wordFactory = new WordFactory();
        DocumentFactory excelFactory = new ExcelFactory();

        System.out.println(pdfFactory.createDocument().create());
        System.out.println(wordFactory.createDocument().create());
        System.out.println(excelFactory.createDocument().create());
    }
}