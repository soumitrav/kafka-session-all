package com.example.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Key {
    @JsonProperty
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Key{" +
                "id='" + id + '\'' +
                '}';
    }
}
