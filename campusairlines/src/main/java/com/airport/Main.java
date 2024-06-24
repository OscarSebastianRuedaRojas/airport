package com.airport;



import com.airport.Manufacture.infrastructure.adapter.in.ManufactureController;


public class Main {
    public static void main(String[] args) {
        ManufactureController manufactureController = new ManufactureController();
        manufactureController.ListManufactures();
    }
}