package com.example.daktarlagbe.model;

public class SpinnerModel {

    private String fieldName;
    private int fieldImage;

    public SpinnerModel(String fieldName, int fieldImage) {
        this.fieldName = fieldName;
        this.fieldImage = fieldImage;
    }

    public String getFieldName() {
        return fieldName;
    }

    public int getFieldImage() {
        return fieldImage;
    }

}
