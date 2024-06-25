package com.airport;

import com.airport.Trip.infrastructure.adapter.in.TripController;
public class Main {
    public static void main(String[] args) {
        TripController control = new TripController();
        control.eliminarTrip();
    }
}~