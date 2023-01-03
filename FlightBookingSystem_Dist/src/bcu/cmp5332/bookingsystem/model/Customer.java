package bcu.cmp5332.bookingsystem.model;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Customer {
    
    private int id;
    private String name;
    private String phone;
    private String email;
    private final List<Booking> bookings = new ArrayList<>();
    
    // TODO: implement constructor here
    public Customer(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;

    }
    
    // TODO: implementation of Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getEmail() {
    	return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }

    public List<Booking> getBookings() {
        return new ArrayList<>(bookings);
    }
	
    public String getDetailsShort() {
        return "Customer #" + id + " - " + name + " - " + phone + " - "  + email;
    }

    public String getDetailsLong() {
        // TODO: implementation here
    	List<String> details = new ArrayList<>();
    	if (!(bookings.isEmpty())) {
	    	for (Booking booking : bookings) {
		    	 String detail = "* Booking date: " + booking.getBookingDate() + " for " + "Flight #" + booking.getFlight().getId() 
		    			 + " - " + booking.getFlight().getFlightNumber()
		        		+ " - " + booking.getFlight().getOrigin() + " to " + booking.getFlight().getDestination()
		        		+ " on " + booking.getFlight().getDepartureDate() + "\n";
		    	 details.add(detail);
	    	}
    	}
    	else {
    		return "Customer #" + id + "\n" + "Name: " + name + "\n" + "Phone: " + phone +" -  Email: "+ email +"\n" 
	        		+ "--------------------------" + "\n" + "there are no bookings for this customer";
    	}
    	String stringDetails = details.toString().replace("[", "").replace("]", "").replace(", ", ""); 
		return "Customer #" + id + "\n" + "Name: " + name + "\n" + "Phone: " + phone  +" -  Email: "+ email +"\n" 
        		+ "--------------------------" + "\n" + "Bookings: " + "\n" + stringDetails + bookings.size() + " booking(s)";
    }
    
    
    public void addBooking(Booking booking) throws FlightBookingSystemException {
        // TODO: implementation here
    	//checks if flight and customer is the same in the bookings list
    	for(Booking existing : bookings) {
    		if ((existing.getCustomer().id == booking.getCustomer().id)
    				&& (existing.getFlight().getId() == booking.getFlight().getId())) {
    			throw new FlightBookingSystemException("There is a booking with same " + "customer and flight in the system");
    			
    		}
    	}
    	bookings.add(booking);
    	//when a booking is made add a passenger to a flight
    	booking.getFlight().addPassenger(this);
    	//Booking object must be created holding a reference to the outbound
    	//and return flights booked and to the customer that made the booking.
    	
    }
    
    //new cancel booking class implemented
    public void  cancelBookingForFlight(Flight flight) throws FlightBookingSystemException {
    	int count = 0;
    	Booking temp = null;
    	for(Booking existing : bookings) {
    		if ((existing.getFlight().getId() == flight.getId())) {
    			//update flight and bookings when cancelled
    			temp = existing;
    			count = 1;
    		}
    	}
    	
    	if(count == 0) {
    		throw new FlightBookingSystemException("list of bookings doesnt contain a booking for the flight");
    	} else {
    		temp.getFlight().removePassenger(this);
			bookings.remove(temp);
			System.out.println("Booking for Customer is successfully cancelled.");
    	}
    	
    }
}
