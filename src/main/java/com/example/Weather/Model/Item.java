package com.example.Weather.Model;
//main table for mongo db connecting to one to many with inventory
public class Item {
    private String id;//unique id
    private String name;//clothes name
    private String color;
    private int quantity;//the amount of the same item you have


    //constructors
    //empty object array
    public Item(){}

    //pass model into item
    public Item(String id, String name, String color, int quantity)
    {
        this.id = id;
        this.name = name;
        this.color = color;
        this.quantity = quantity;
    }

    //getters and setters
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
    return "item quantity: " + this.getQuantity() +
           ", item name: " + this.getName() +
             ", item color: " + this.getColor();
    }

}
