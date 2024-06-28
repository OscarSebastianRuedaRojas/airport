package com.airport;

import java.util.Scanner;

import com.airport.Customer.infrastructure.adapter.in.CustomerBookingController;


public class Main {
    public static void main(String[] args) {
       CustomerBookingController CBC = new CustomerBookingController();
       CBC.CreateFlightBooking();
    }
}