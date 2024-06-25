package com.airport;
import com.airport.City.infrastructure.adapter.in.CityController;
public class Main {
    public static void main(String[] args) {
        CityController city = new CityController();
        city.listCitys();
    }
}