package bcu.cmp5332.bookingsystem.commands;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Booking;
import bcu.cmp5332.bookingsystem.model.Customer;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;
import bcu.cmp5332.bookingsystem.data.DataManager;

public class AddBooking implements Command, DataManager {
	private int customerID;
	private int flightID;
	private LocalDate date;
	public final String RESOURCE = "./resources/data/bookings.txt";
	
	public AddBooking(int customerID, int flightID) {
		this.customerID = customerID;
		this.flightID = flightID;
		this.date = LocalDate.now();
	}
	
	@Override
	public void storeData(FlightBookingSystem fbs) throws IOException{
		// TODO Auto-generated method stub
    	try (PrintWriter out = new PrintWriter(new FileWriter(RESOURCE))) {
            for (Customer customer : fbs.getCustomers()) {
            	for (Booking booking : customer.getBookings()) {
//            		out.print(booking.getBookingId() + SEPARATOR);
                    out.print(booking.getCustomer().getId() + SEPARATOR);
                    out.print(booking.getFlight().getId() + SEPARATOR);
                    out.print(booking.getBookingDate() + SEPARATOR);
                    out.println();
            		
            	}
            }
        }
		
	}
	
	@Override
	public void loadData(FlightBookingSystem fbs) throws IOException, FlightBookingSystemException {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
		// TODO Auto-generated method stub
		try {
			Booking booking = new Booking(flightBookingSystem.getCustomerByID(customerID), flightBookingSystem.getFlightByID(flightID), date);
			flightBookingSystem.getCustomerByID(customerID).addBooking(booking);
			storeData(flightBookingSystem);
			System.out.println("Booking for Customer #" + customerID + " been added.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FlightBookingSystemException e) {
			// TODO Auto-generated catch block
			throw new FlightBookingSystemException("Error: Unable to save.");
		}
		//System.out.println("Booking for Customer #" + customerID + " been added.");
		
	}


	

}
