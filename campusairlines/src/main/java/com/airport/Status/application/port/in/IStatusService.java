package com.airport.Status.application.port.in;

import java.util.List;

import com.airport.Status.domain.Status;

public interface IStatusService {
    Status save(Status status);
    List<Status> ListStatus(Status status);
}