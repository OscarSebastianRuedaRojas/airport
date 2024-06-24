package com.airport;
import com.airport.FlightFare.infrastructure.adapter.in.FlightFareController;

public class Main {
    public static void main(String[] args) {
        FlightFareController troll = new FlightFareController();
        troll.registerFlightfare();
        troll.flightFaresList();
    }
}