package com.structural.adapter;

public class LegacyDataFormat {
    private String data;

    public LegacyDataFormat(String data) {
        this.data = data;
    }

    public String getLegacyData() {
        return "Legacy Data: " + data;
    }
}