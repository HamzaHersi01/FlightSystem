package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

public class ShowFlight implements Command{
	private int id;
	
	public ShowFlight (int id) {
		this.id = id;
	}

    @Override
    public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
    	//shows the long details of the particular flight object that is retrieved using the flight id and method from fbs
    	System.out.println(flightBookingSystem.getFlightByID(id).getDetailsLong());
    }
    

}
