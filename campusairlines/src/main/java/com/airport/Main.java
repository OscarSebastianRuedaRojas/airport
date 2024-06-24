package com.airport;
import com.airport.TripulationRol.infrastructure.adapter.in.TripulationRolController;

public class Main {
    public static void main(String[] args) {
        TripulationRolController troll = new TripulationRolController();
        troll.registerTripulationRol();
        troll.listTripulationRol();
    }
}