package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Flight;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;
import bcu.cmp5332.bookingsystem.data.DataManager;

import java.io.IOException;
import java.time.LocalDate;

public class AddFlight implements  Command,DataManager {

    private final String flightNumber;
    private final String origin;
    private final String destination;
    private final LocalDate departureDate;
    private int flightCapacity;
    private int price;
    
    public AddFlight(String flightNumber, String origin, String destination, LocalDate departureDate,int flightCapacity,int price) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.flightCapacity = flightCapacity;
        this.price = price;
    }
    
	@Override
	public void loadData(FlightBookingSystem fbs) throws IOException, FlightBookingSystemException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storeData(FlightBookingSystem fbs) throws IOException {
		// TODO Auto-generated method stub
		
	}
    
    @Override
    public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
        int maxId = 0;
        if (flightBookingSystem.getFlights().size() > 0) {
            int lastIndex = flightBookingSystem.getFlights().size() - 1;
            maxId = flightBookingSystem.getFlights().get(lastIndex).getId();
        }
        
        Flight flight = new Flight(++maxId, flightNumber, origin, destination, departureDate, flightCapacity, price);
        flightBookingSystem.addFlight(flight);
        System.out.println("Flight #" + flight.getId() + " added.");
        
        
    }


}
