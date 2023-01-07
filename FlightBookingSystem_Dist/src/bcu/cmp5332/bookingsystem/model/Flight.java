package bcu.cmp5332.bookingsystem.model;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Flight {
    
    private int id;
    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDate departureDate;
    private int flightCapacity;
    private int price;
    private boolean removed= false;

    private final Set<Customer> passengers;

    public Flight(int id, String flightNumber, String origin, String destination, LocalDate departureDate, int flightCapacity,int price) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.flightCapacity= flightCapacity;
        this.price= price;
        this.removed = removed;
        
        passengers = new HashSet<>();
    }
    
    public boolean getRemoved() {
    	return removed;
    }
    
    public void setRemoved(boolean removed) {
    	this.removed = removed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }
    

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    
    public String getOrigin() {
        return origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
    
    public int getFlightCapacity() {
    	return flightCapacity;
    }
    
    public void setFlightCapacity(int flightCapacity) {
    	this.flightCapacity = flightCapacity;
    }
    
    public int getPrice() {
    	return price;
    }
    
    public void setPrice(int price) {
    	this.price = price;
    }

    public List<Customer> getPassengers() {
        return new ArrayList<>(passengers);
    }
	
    public String getDetails() {
        // TODO: implementation here
    	List<String> details = new ArrayList<>();
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        if (!(passengers.isEmpty())) {
	    	for (Customer customer : passengers) {
	    		String detail = "* Id: " + customer.getId() + " - Name: " + customer.getName()  + " - Phone: " +
	        			customer.getPhone() + "\r\n";
	    		details.add(detail);
	    	}
    	}
    	else {
    		return "Flight #" + id + " - " + flightNumber + " - " + origin + " to " + destination + " on " 
        			+ departureDate.format(dtf) + "\n" + "--------------------------" + "\n" +
    				"there are no passengers for this flight";
    	}
        String stringDetails = details.toString().replace("[", "").replace("]", "").replace(", ", "");
        System.out.println(stringDetails);
		return "Flight# " + id + "\n" 
    			 + " Passengers: " + "\n" + stringDetails 
    			+ passengers.size() + " passenger(s)";
    }
    
    
    public String getDetailsShort() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        return "Flight #" + id + " - " + flightNumber + " - " + origin + " to " 
                + destination + " on " + departureDate.format(dtf) + " -  Capacity: " + flightCapacity + " -  Price: " + price;
    }

    public String getDetailsLong() {
        // TODO: implementation here
    	List<String> details = new ArrayList<>();
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        if (!(passengers.isEmpty())) {
	    	for (Customer customer : passengers) {
	    		String detail = "* Id: " + customer.getId() + " - Name: " + customer.getName()  + " - Phone: " +
	        			customer.getPhone() + "\n";
	    		details.add(detail);
	    	}
    	}
    	else {
    		return "Flight #" + id + " - " + flightNumber + " - " + origin + " to " + destination + " on " 
        			+ departureDate.format(dtf) + "\n" + "--------------------------" + "\n" +
    				"there are no passengers for this flight";
    	}
        String stringDetails = details.toString().replace("[", "").replace("]", "").replace(", ", "");
		return "Flight #" + id + "\n" + "Flight No: " + flightNumber + "\n" + "Origin: " + origin + "\n" + "Destination: " + destination + "\n" 
    			+ "Departure Date: " + departureDate.format(dtf) + "\n" + "--------------------------" + "\n" + "Passengers: " + "\n" + stringDetails 
    			+ passengers.size() + " passenger(s)";
    }
    
    public void addPassenger(Customer passenger) throws FlightBookingSystemException {
//    	if (passengers.contains(passenger)) {
//            throw new IllegalArgumentException("Duplicate passenger ID.");
//        }
        for (Customer existing : passengers) {
            if (existing.getId() == passenger.getId()) {
                throw new FlightBookingSystemException("There is a passenger with same "
                        + "id");
            }
        }
        passengers.add(passenger);
        
    }
    //new class remove passenger
    public void removePassenger(Customer passenger) throws FlightBookingSystemException {
    	int count = 0;
        for (Customer existing : passengers) {
            if (existing.getId() == passenger.getId()) {
                passengers.remove(passenger);
                count = 1;
            }
        }
    	
        if(count == 0) {
    		throw new FlightBookingSystemException("list of passengers doesnt contain the current passenger");
    	}
        
    }
    
}
