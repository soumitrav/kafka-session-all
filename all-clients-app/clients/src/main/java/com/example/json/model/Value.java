package com.example.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Value {
    @JsonProperty
    Key key;
    @JsonProperty
    String employeeName;
    @JsonProperty
    String location;

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Value{" +
                "key=" + key +
                ", employeeName='" + employeeName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
