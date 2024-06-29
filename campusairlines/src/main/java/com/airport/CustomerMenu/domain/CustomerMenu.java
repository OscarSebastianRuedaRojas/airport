package com.airport.CustomerMenu.domain;

import com.airport.Customer.infrastructure.adapter.in.CustomerBookingController;
import com.airport.TripBookingDetail.infrastructure.adapter.in.TripBookingDetailController;

public class CustomerMenu {
    private final CustomerBookingController customerBookingController;
    private final TripBookingDetailController tripBookingDetailController;
    public CustomerMenu() {
        this.customerBookingController = new CustomerBookingController();
        this.tripBookingDetailController = new TripBookingDetailController();
    }
    public CustomerBookingController getCustomerBookingController() {
        return customerBookingController;
    }
    public TripBookingDetailController getTripBookingDetailController() {
        return tripBookingDetailController;
    }

}
