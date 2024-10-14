package com.example.Weather.Model;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "inventory")
//Spring that the class should be mapped to a MongoDB collection.

public class Inventory {

    private String id;
    private String name;
    private List<Item> items;

     // Constructors
    public Inventory() {}

    public Inventory(String id, String name, List<Item> items) {
        this.id = id;
        this.name = name;
        this.items = items;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
