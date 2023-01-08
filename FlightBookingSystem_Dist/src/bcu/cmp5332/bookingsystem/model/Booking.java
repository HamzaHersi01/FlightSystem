package bcu.cmp5332.bookingsystem.model;

import java.time.LocalDate;

public class Booking {
    private int id;
    private Customer customer;
    private Flight flight;
    private LocalDate bookingDate;
    

    //initialises the attributes for booking class
    public Booking(int id,Customer customer, Flight flight, LocalDate bookingDate) {
        // TODO: implementation here
    	this.id = id;
    	this.customer = customer;
    	this.flight = flight;
    	this.bookingDate = bookingDate;
        
    }
    
    // TODO: implementation of Getter and Setter methods
    
    public int getBookingId() {
		return id;
	}
    
    public void setBookingId(int id) {
    	this.id=id;
    }


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Flight getFlight() {
		return flight;
	}


	public void setFlight(Flight flight) {
		this.flight = flight;
	}


	public LocalDate getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
    
    
    
    
}
