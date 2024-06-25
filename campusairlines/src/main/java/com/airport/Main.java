package com.airport;
import com.airport.Airport.infrastructure.adapter.in.AirportController;
import com.airport.DocumentType.infrastructure.adapter.in.DocumentTypeController;

public class Main {
    public static void main(String[] args) {
        DocumentTypeController troll = new DocumentTypeController();
        troll.updateDocumentType();
    }
}