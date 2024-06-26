package com.airport;

import com.airport.Revision.infrastructure.adapter.in.RevisionController;
public class Main {
    public static void main(String[] args) {
        RevisionController control = new RevisionController();
        control.getRevisionByPlanePlate();
    }
}