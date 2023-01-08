package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Flight;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;
import bcu.cmp5332.bookingsystem.data.DataManager;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class AddFlight implements  Command,DataManager {
//inizializes the varaibles
    private final String flightNumber;
    private final String origin;
    private final String destination;
    private final LocalDate departureDate;
    private int flightCapacity;
    private int price;
    private boolean removed = false;
    private final String RESOURCE = "./resources/data/flights.txt";
    //sets up the cosntructor 
    public AddFlight(String flightNumber, String origin, String destination, LocalDate departureDate,int flightCapacity,int price) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.flightCapacity = flightCapacity;
        this.price = price;
        this.removed = removed;
    }
    
	@Override
	public void loadData(FlightBookingSystem fbs) throws IOException, FlightBookingSystemException {
		// TODO Auto-generated method stub
		
	}
//stores the data in a text file using PrintWirter
	@Override
    public void storeData(FlightBookingSystem fbs) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(RESOURCE))) {
            for (Flight flight : fbs.getFlights()) {
                out.print(flight.getId() + SEPARATOR);
                out.print(flight.getFlightNumber() + SEPARATOR);
                out.print(flight.getOrigin() + SEPARATOR);
                out.print(flight.getDestination() + SEPARATOR);
                out.print(flight.getDepartureDate() + SEPARATOR);
                out.print(flight.getFlightCapacity() + SEPARATOR);
                out.print(flight.getPrice() + SEPARATOR);
                out.print(flight.getRemoved() + SEPARATOR );
                out.println();
            }
        }
    }
    //adds the flight with a new id by subtracting one from the max id then using that as an id to add the new flight and saving the information to texfile
    @Override
    public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
    	
        int maxId = 0;
        if (flightBookingSystem.getFlights().size() > 0) {
            int lastIndex = flightBookingSystem.getFlights().size() - 1;
            maxId = flightBookingSystem.getFlights().get(lastIndex).getId();
        }
     
        Flight flight = new Flight(++maxId, flightNumber, origin, destination, departureDate, flightCapacity, price);
        flightBookingSystem.addFlight(flight);
        try {
			storeData(flightBookingSystem);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Flight #" + flight.getId() + " added.");
    	
    		
    	
    	
        
        
    }


}
