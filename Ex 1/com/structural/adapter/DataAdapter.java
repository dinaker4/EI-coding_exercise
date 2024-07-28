package com.structural.adapter;

public class DataAdapter implements ModernDataFormat {
    private LegacyDataFormat legacyData;

    public DataAdapter(LegacyDataFormat legacyData) {
        this.legacyData = legacyData;
    }

    @Override
    public String getModernData() {
        String[] parts = legacyData.getLegacyData().split(": ");
        return "Modern Data: " + parts[1];
    }
}