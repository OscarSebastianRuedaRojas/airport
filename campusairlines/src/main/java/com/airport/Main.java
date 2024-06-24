package com.airport;
import com.airport.City.infrastructure.adapter.in.CityController;

public class Main {
    public static void main(String[] args) {
        CityController troll = new CityController();
        troll.registerCity();
        troll.cityList();
    }
}