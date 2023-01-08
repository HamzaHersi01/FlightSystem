package bcu.cmp5332.bookingsystem.model;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import java.time.LocalDate;
import java.util.*;

public class FlightBookingSystem {
    
    private final LocalDate systemDate = LocalDate.parse("2020-11-11");
    
    private final Map<Integer, Customer> customers = new TreeMap<>();
    private final Map<Integer, Flight> flights = new TreeMap<>();

    public LocalDate getSystemDate() {
        return systemDate;
    }

    public List<Flight> getFlights() {
        List<Flight> out = new ArrayList<>(flights.values());
        return Collections.unmodifiableList(out);
    }
    //new method added: returns an array list of customers 
    public List<Customer> getCustomers() {
        List<Customer> out = new ArrayList<>(customers.values());
        return Collections.unmodifiableList(out);
    }

    public Flight getFlightByID(int id) throws FlightBookingSystemException {
        if (!flights.containsKey(id)) {
            throw new FlightBookingSystemException("There is no flight with that ID.");
        }
        return flights.get(id);
    }

    public Customer getCustomerByID(int id) throws FlightBookingSystemException {
        // TODO: implementation here
    	//method implemented
    	if (!(customers.containsKey(id))) {
            throw new FlightBookingSystemException("There is no customer with that ID.");
        }
        return customers.get(id);
    }

    public void addFlight(Flight flight) throws FlightBookingSystemException {
        if (flights.containsKey(flight.getId())) {
            throw new IllegalArgumentException("Duplicate flight ID.");
        }
        for (Flight existing : flights.values()) {
            if (existing.getFlightNumber().equals(flight.getFlightNumber()) 
                && existing.getDepartureDate().isEqual(flight.getDepartureDate())) {
                throw new FlightBookingSystemException("There is a flight with same "
                        + "number and departure date in the system");
            }
        }
        flights.put(flight.getId(), flight);
    }
    //implement this using addFlight method
    public void addCustomer(Customer customer) throws FlightBookingSystemException {
        // TODO: implementation here
    	//implemented but checks if name and phone number is equal
    	if (customers.containsKey(customer.getId())) {
            throw new IllegalArgumentException("Duplicate customer ID.");
        }
        for (Customer existing : customers.values()) {
            if (existing.getName().equals(customer.getName()) 
                && existing.getPhone().equals(customer.getPhone())) {
                throw new FlightBookingSystemException("There is a customer with same "
                        + "name and phone number in the system");
            }
        }
        customers.put(customer.getId(), customer);
    	
    }
    
    public void removeFlight(int id) throws FlightBookingSystemException{
    	//int count = 0;
    	 List<Customer> f1 = getFlightByID(id).getPassengers();
    	 
    	 List<Integer> toRemove = new ArrayList<>();
    	 Flight flightyID = getFlightByID(id);
    	//Customer temp = null;
    	if(flights.containsKey(id) ) {
    		getFlightByID(id).setRemoved(true);
    		for(Customer customer : getFlightByID(id).getPassengers()) {
    			//toRemove.add(f1.get(i));
    			toRemove.add(customer.getId());
    			//temp.cancelBookingForFlight(flightyID);
    			
    		}
    		
    		for (int customer2 : toRemove ) {
    			getCustomerByID(customer2).cancelBookingForFlight(flightyID);;
    			
    		}
    		
//    		for (int customer2 : toRemove ) {
//    			//customer2.cancelBookingForFlight(flightyID);
//    		}
    		
    		//flights.remove(id);
    		//flight.setRemoved(true);
    		
    	}else {
    		throw new FlightBookingSystemException("There are no flights with that ID");
    		}
    	
    }
//  public void delFlight(int flightId) throws FlightBookingSystemException {
//	if (!flights.containsKey(flightId)) {
//        throw new FlightBookingSystemException("There is no flight with that ID.");
//    }
//	for (Customer existing : getFlightByID(flightId).getPassengers()) {
//		//existing.cancelBookingForFlight(getFlightByID(flightId));
//		
//	}
//	
//	flights.remove(flightId);
//}
}
