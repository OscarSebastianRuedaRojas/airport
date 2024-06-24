package com.airport.Status.application.port.out;

import java.util.List;

import com.airport.Status.domain.Status;

public interface StatusRepositoryPort {

    Status save(Status status);
    List<Status> findAll();
}