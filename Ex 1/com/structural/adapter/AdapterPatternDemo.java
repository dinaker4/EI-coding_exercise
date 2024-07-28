package com.structural.adapter;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        LegacyDataFormat legacyData = new LegacyDataFormat("Important information");
        ModernDataFormat modernSystem = new DataAdapter(legacyData);

        System.out.println(modernSystem.getModernData());
    }
}