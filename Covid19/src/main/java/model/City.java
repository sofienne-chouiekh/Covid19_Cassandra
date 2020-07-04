package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MSellami
 */
public class City {
    public String CityName;
    public int IDCity;
    public double Longitude;
    public double Latitude;
    public double population;

    public int getIDCity() {
        return IDCity;
    }

    public void setIDCity(int IDCity) {
        this.IDCity = IDCity;
    }

    public City(int IDCity,String CityName, double Longitude, double latitude, double population) {
        this.IDCity=IDCity;
        this.CityName = CityName;
        this.Longitude = Longitude;
        this.Latitude = latitude;
        this.population = population;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double Longitude) {
        this.Longitude = Longitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        this.Latitude = latitude;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }
    
    
    
}
