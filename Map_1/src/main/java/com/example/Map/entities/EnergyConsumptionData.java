package com.example.Map.entities;

public class EnergyConsumptionData {
    private int id;
    private String country_name;
    private String country_iso;
    private int year;
    private String energy_consumption;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCountry_name() {
        return country_name;
    }
    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
    public String getCountry_iso() {
        return country_iso;
    }
    public void setCountry_iso(String country_iso) {
        this.country_iso = country_iso;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getEnergy_consumption() {
        return energy_consumption;
    }
    public void setEnergy_consumption(String energy_consumption) {
        this.energy_consumption = energy_consumption;
    }
    @Override
    public String toString() {
        return " [id=" + id + ", country_name=" + country_name + ", country_iso=" + country_iso + ", year="
                + year + ", energy_consumption=" + energy_consumption + "]";
    }
    

}
