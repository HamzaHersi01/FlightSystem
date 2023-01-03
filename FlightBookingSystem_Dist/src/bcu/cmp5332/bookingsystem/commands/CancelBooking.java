package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

public class CancelBooking implements Command {
	private int customerID;
	private int flightId;
	public CancelBooking(int customerID, int flightID) {
		this.customerID = customerID;
		this.flightId = flightID;
	}

	@Override
	public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
		// TODO Auto-generated method stub
		flightBookingSystem.getCustomerByID(customerID).cancelBookingForFlight(flightBookingSystem.getFlightByID(flightId));
		
	}

}
