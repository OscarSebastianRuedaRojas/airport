package com.airport.Status.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.airport.Status.application.service.StatusService;
import com.airport.Status.domain.Status;

public class StatusController {

    private StatusService statusService;
    private Scanner input;

    public StatusController() {
        this.statusService = new StatusService();
        this.input = new Scanner(System.in);
    }

    public void registerStatus(){
        try {
            Status status = new Status();
            System.out.println("Ingresa el nombre del Status");
            status.setName(input.nextLine());
            statusService.save(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Long listStatuses(){
        try {
            List<Status> statuses = statusService.ListStatus();
            System.out.println("Status disponibles:");
            for (Status status : statuses) {
                System.out.println(String.format("%d. %s", status.getId(), status.getName()));
            }
            Long id = input.nextLong();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}