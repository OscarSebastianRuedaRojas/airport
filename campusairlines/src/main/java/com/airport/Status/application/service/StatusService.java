package com.airport.Status.application.service;

import java.util.List;

import com.airport.Status.application.port.in.IStatusService;
import com.airport.Status.domain.Status;
import com.airport.Status.infrastructure.adapter.out.StatusRepository;

public class StatusService implements IStatusService{

    StatusRepository statusRepository;

    
    public StatusService() {
        this.statusRepository = new StatusRepository();
    }

    @Override
    public Status save(Status status) {
        try {
            Status newStatus = statusRepository.save(status);
            return newStatus;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Status> ListStatus() {
        try {
            List<Status> statuses = statusRepository.findAll();
            return statuses;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
}