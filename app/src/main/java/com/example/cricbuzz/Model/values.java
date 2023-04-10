package com.example.cricbuzz.Model;

import com.google.gson.annotations.SerializedName;

public class values {

    private String[] value;

    @SerializedName("values")
    values[] values;

    public String[] getValue() {
        return value;
    }

    public void setValue(String[] value) {
        this.value = value;
    }

    public values[] getValues() {
        return values;
    }

    public void setValues(values[] values) {
        this.values = values;
    }
}
