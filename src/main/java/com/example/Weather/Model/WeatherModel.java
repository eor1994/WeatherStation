package com.example.Weather.Model;

public class WeatherModel {

    private String city;
    private String country;
    private String description;
    private double temperature;
    private double latitude;
    private double longitude;


    public WeatherModel(){}
    // Constructor, getters, and setters
    public WeatherModel(String city, String country, String description, double temperature, double latitude, double longitude) {
        this.city = city;
        //country code
        this.country = country;
        this.description = description;
        this.temperature = temperature;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    //country -added
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

     public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}