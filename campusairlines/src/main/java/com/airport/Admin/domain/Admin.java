package com.airport.Admin.domain;


import com.airport.Airport.infrastructure.adapter.in.AirportController;
import com.airport.DocumentType.infrastructure.adapter.in.DocumentTypeController;
import com.airport.FlighConnection.infrastructure.adapter.in.FlightConnectionController;
import com.airport.FlightFare.infrastructure.adapter.in.FlightFareController;
import com.airport.Plane.infrastructure.adapter.in.PlaneController;
import com.airport.Trip.infrastructure.adapter.in.TripController;
import com.airport.TripCrew.infrastructure.adapter.in.TripCrewController;

/**
 * Admin
 */
public class Admin {

    private PlaneController planeController;
    private AirportController airportController;
    private TripController tripController;
    private TripCrewController tripCrewController;
    private FlightConnectionController flightConnectionController;
    private FlightFareController flightFareController;
    private DocumentTypeController documentTypeController;

    public Admin() {
        this.planeController = new PlaneController();
        this.airportController = new AirportController();
        this.tripController = new TripController();
        this.tripCrewController = new TripCrewController();
        this.flightConnectionController = new FlightConnectionController();
        this.flightFareController = new FlightFareController();
        this.documentTypeController = new DocumentTypeController();
    }

    public PlaneController getPlaneController() {
        return planeController;
    }

    public void setPlaneController(PlaneController planeController) {
        this.planeController = planeController;
    }

    public AirportController getAirportController() {
        return airportController;
    }

    public void setAirportController(AirportController airportController) {
        this.airportController = airportController;
    }

    public TripController getTripController() {
        return tripController;
    }

    public void setTripController(TripController tripController) {
        this.tripController = tripController;
    }

    public TripCrewController getTripCrewController() {
        return tripCrewController;
    }

    public void setTripCrewController(TripCrewController tripCrewController) {
        this.tripCrewController = tripCrewController;
    }

    public FlightConnectionController getFlightConnectionController() {
        return flightConnectionController;
    }

    public void setFlightConnectionController(FlightConnectionController flightConnectionController) {
        this.flightConnectionController = flightConnectionController;
    }

    public FlightFareController getFlightFareController() {
        return flightFareController;
    }

    public void setFlightFareController(FlightFareController flightFareController) {
        this.flightFareController = flightFareController;
    }

    public DocumentTypeController getDocumentTypeController() {
        return documentTypeController;
    }

    public void setDocumentTypeController(DocumentTypeController documentTypeController) {
        this.documentTypeController = documentTypeController;
    }

    

}