package com.example.Weather.Model;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class WeatherModel {

    private String city;
    private String description;
    private double temperature;

    // Constructor, getters, and setters
    public WeatherModel(String city, String description, double temperature) {
        this.city = city;
        this.description = description;
        this.temperature = temperature;
    }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }
}

