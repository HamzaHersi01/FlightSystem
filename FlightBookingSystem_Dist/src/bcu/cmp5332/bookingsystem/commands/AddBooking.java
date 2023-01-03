package bcu.cmp5332.bookingsystem.commands;

import java.time.LocalDate;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Booking;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

public class AddBooking implements Command {
	private int customerID;
	private int flightID;
	private LocalDate date;
	
	public AddBooking(int customerID, int flightID) {
		this.customerID = customerID;
		this.flightID = flightID;
		this.date = LocalDate.now();
	}

	@Override
	public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
		// TODO Auto-generated method stub
		Booking booking = new Booking(flightBookingSystem.getCustomerByID(customerID), flightBookingSystem.getFlightByID(flightID), date);
		flightBookingSystem.getCustomerByID(customerID).addBooking(booking);
		System.out.println("Booking for Customer #" + customerID + " been added.");
		
	}
	

}
