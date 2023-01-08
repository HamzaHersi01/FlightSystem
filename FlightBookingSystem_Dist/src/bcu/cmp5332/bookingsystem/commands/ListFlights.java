package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Flight;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;
import java.time.LocalDate;

import java.util.List;

public class ListFlights implements Command {
	LocalDate today = LocalDate.now();


    @Override
    public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
    	//goes through each flight object from the flightbookingSystem list of flights and it checks if todays date
    	//is before the departure date, if true it prints the deatils short method of flights and prints number of flights 
        List<Flight> flights = flightBookingSystem.getFlights();
        for (Flight flight : flights) {
        	//if(flight.getRemoved()== false) {
        		
        		if(today.isBefore(flight.getDepartureDate())) {
                System.out.println(flight.getDetailsShort());
            	//}
        		}
        }
        System.out.println(flights.size() + " flight(s)");
    }
}
