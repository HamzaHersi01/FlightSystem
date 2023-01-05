package bcu.cmp5332.bookingsystem.commands;


import java.io.IOException;
import java.time.LocalDate;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Booking;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;
import bcu.cmp5332.bookingsystem.data.DataManager;

public class AddBooking implements Command, DataManager {
	private int customerID;
	private int flightID;
	private LocalDate date;
	
	public AddBooking(int customerID, int flightID) {
		this.customerID = customerID;
		this.flightID = flightID;
		this.date = LocalDate.now();
	}
	
	@Override
	public void storeData(FlightBookingSystem fbs) throws IOException{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void loadData(FlightBookingSystem fbs) throws IOException, FlightBookingSystemException {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
		// TODO Auto-generated method stub
		Booking booking = new Booking(flightBookingSystem.getCustomerByID(customerID), flightBookingSystem.getFlightByID(flightID), date);
		flightBookingSystem.getCustomerByID(customerID).addBooking(booking);
		//storeData();
		System.out.println("Booking for Customer #" + customerID + " been added.");
		
	}


	

}
