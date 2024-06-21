package com.airport;


import com.airport.Airlines.domain.Airlines;
import com.airport.Airlines.infrastructure.adapter.out.AirlinesRepository;
@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
        AirlinesRepository dasd = new AirlinesRepository();
        Airlines aero = dasd.findById(1L);
        System.out.println(aero.getairline_name());


    }
}