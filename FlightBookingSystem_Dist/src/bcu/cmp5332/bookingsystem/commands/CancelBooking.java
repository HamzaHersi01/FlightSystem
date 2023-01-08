package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Booking;
import bcu.cmp5332.bookingsystem.model.Customer;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

import bcu.cmp5332.bookingsystem.data.DataManager;

public class CancelBooking implements Command,DataManager {
	private int customerID;
	private int flightId;
	public final String RESOURCE = "./resources/data/bookings.txt";
	public CancelBooking(int customerID, int flightID) {
		this.customerID = customerID;
		this.flightId = flightID;
	}
	
    @Override
    public void loadData(FlightBookingSystem fbs) throws IOException, FlightBookingSystemException {
        // TODO: implementation here
       	try (Scanner sc = new Scanner(new File(RESOURCE))) {
            int line_idx = 1;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] properties = line.split(SEPARATOR, -1);
                try {
                	int id = Integer.parseInt(properties[0]);
                    int customerID = Integer.parseInt(properties[1]);
                    int flightID = Integer.parseInt(properties[2]);
                    LocalDate bookingDate = LocalDate.parse(properties[3]);
              
                    Booking booking = new Booking(id,fbs.getCustomerByID(customerID), fbs.getFlightByID(flightID), bookingDate);
                    fbs.getCustomerByID(customerID).addBooking(booking);
                } catch (NumberFormatException ex) {
                    throw new FlightBookingSystemException("Unable to parse booking " + " on line " + line_idx
                        + "\nError: " + ex);
                }
                line_idx++;
                
            }
        }
    }
    

    @Override
    public void storeData(FlightBookingSystem fbs) throws IOException {
        // TODO: implementation here
    	try (PrintWriter out = new PrintWriter(new FileWriter(RESOURCE))) {
            for (Customer customer : fbs.getCustomers()) {
            	for (Booking booking : customer.getBookings()) {
           		    out.print(booking.getBookingId() + SEPARATOR);
                    out.print(booking.getCustomer().getId() + SEPARATOR);
                    out.print(booking.getFlight().getId() + SEPARATOR);
                    out.print(booking.getBookingDate() + SEPARATOR);
                    out.println();
            		
            	}
            }
        }
    }
	


	@Override
	public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
		// TODO Auto-generated method stub
		try {
			flightBookingSystem.getCustomerByID(customerID).cancelBookingForFlight(flightBookingSystem.getFlightByID(flightId));
			storeData(flightBookingSystem);
		} catch (FlightBookingSystemException ex) {
			// TODO Auto-generated catch block
			throw new FlightBookingSystemException("Error: Unable to save.");
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	}

	

}
