package bcu.cmp5332.bookingsystem.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Flight;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

public class ShowCustomer implements Command {
	int id;
	
	public ShowCustomer(int id) {
		this.id = id;
	}

    @Override
    public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
    	//shows specific customers long details through the method by parsing in the customers id
    	System.out.println(flightBookingSystem.getCustomerByID(id).getDetailsLong());
    }
    
    

}
