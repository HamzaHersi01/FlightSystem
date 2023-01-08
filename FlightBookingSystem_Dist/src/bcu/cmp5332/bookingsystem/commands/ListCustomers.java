package bcu.cmp5332.bookingsystem.commands;

import java.util.List;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Customer;
import bcu.cmp5332.bookingsystem.model.Flight;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;
//new class added to list all customers
public class ListCustomers implements Command {
	  
		@Override
	    public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
			//has a list of customers from the flightbookingSystem and it goes through each customer in the list to print out 
			//the get details short method and also prints out the number of customers
	        List<Customer> customers = flightBookingSystem.getCustomers();
	        for (Customer customer : customers) {
	            System.out.println(customer.getDetailsShort());
	        }
	        System.out.println(customers.size() + " customer(s)");
	    }

}
