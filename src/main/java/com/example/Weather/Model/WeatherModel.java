package com.example.Weather.Model;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class WeatherModel {

    private String city;
    private String country;
    private String description;
    private double temperature;

    // Constructor, getters, and setters
    public WeatherModel(String city, String country, String description, double temperature) {
        this.city = city;
        //country code
        this.country = country;
        this.description = description;
        this.temperature = temperature;
    }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    //country -added
    public String getCountry() { return country; }
    public void getCountry(String city) { this.country = country; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

}

