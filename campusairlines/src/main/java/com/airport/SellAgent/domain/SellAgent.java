package com.airport.SellAgent.domain;

import com.airport.Customer.infrastructure.adapter.in.CustomerController;
import com.airport.DocumentType.infrastructure.adapter.in.DocumentTypeController;
import com.airport.FlighConnection.infrastructure.adapter.in.FlightConnectionController;
import com.airport.FlightFare.infrastructure.adapter.in.FlightFareController;
import com.airport.Trip.infrastructure.adapter.in.TripController;
import com.airport.TripBookingDetail.infrastructure.adapter.in.TripBookingDetailController;
import com.airport.TripCrew.infrastructure.adapter.in.TripCrewController;

public class SellAgent {

    private CustomerController customerController;
    private TripBookingDetailController tripBookingDetailController;
    private TripController tripController;
    private TripCrewController tripCrewController;
    private FlightConnectionController flightConnectionController;
    private FlightFareController flightFareController;
    private DocumentTypeController documentTypeController;
    
    public SellAgent() {
        this.customerController = new CustomerController();
        this.tripBookingDetailController = new TripBookingDetailController();
        this.tripController = new TripController();
        this.tripCrewController = new TripCrewController();
        this.flightConnectionController = new FlightConnectionController();
        this.flightFareController = new FlightFareController() ;
        this.documentTypeController = new DocumentTypeController();
    }

    public CustomerController getCustomerController() {
        return customerController;
    }

    public void setCustomerController(CustomerController customerController) {
        this.customerController = customerController;
    }

    public TripBookingDetailController getTripBookingDetailController() {
        return tripBookingDetailController;
    }

    public void setTripBookingDetailController(TripBookingDetailController tripBookingDetailController) {
        this.tripBookingDetailController = tripBookingDetailController;
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
