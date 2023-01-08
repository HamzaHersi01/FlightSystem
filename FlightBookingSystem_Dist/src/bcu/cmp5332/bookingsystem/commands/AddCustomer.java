package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Booking;
import bcu.cmp5332.bookingsystem.model.Customer;
import bcu.cmp5332.bookingsystem.model.Flight;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import bcu.cmp5332.bookingsystem.data.DataManager;

public class AddCustomer implements Command, DataManager {
	//initalizes the varaibles
    private final String name;
    private final String phone;
    private final String email;
    private final String RESOURCE = "./resources/data/customers.txt";

    public AddCustomer(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
//uses the PrintWriter class to store a new customer and by it appending with a delimiter.
	@Override
    public void storeData(FlightBookingSystem fbs) throws IOException {
        // TODO: implementation here
    	try (PrintWriter out = new PrintWriter(new FileWriter(RESOURCE))) {
            for (Customer customer : fbs.getCustomers()) {
                out.print(customer.getId() + SEPARATOR);
                out.print(customer.getName() + SEPARATOR);
                out.print(customer.getPhone() + SEPARATOR);
                out.print(customer.getEmail() + SEPARATOR);
                out.println();
            }
        }
    }
	
	@Override
	public void loadData(FlightBookingSystem fbs) throws IOException, FlightBookingSystemException {
		// TODO Auto-generated method stub
		
	}

    @Override
    public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
        // TODO: implementation here
//    	 int maxId = 0;
//         if (flightBookingSystem.getCustomers().size() > 0) {
//             int lastIndex = flightBookingSystem.getCustomers().size() - 1;
//             maxId = flightBookingSystem.getCustomers().get(lastIndex).getId();
//         }
//         
//         Customer customer = new Customer(++maxId, name, phone, email);
//         flightBookingSystem.addCustomer(customer);
//         System.out.println("Customer #" + customer.getId() + " added.");
    	
    	
         // gets next usable id by getting the total amount of customers then adding +1 to it 
    	//it then creates a new customer object and uses the id just created as one of the parameteres along side the rest of them
    	//the customer is then added to the flight booking system and the data is saved
     	try {
     		int maxId = 0;
            if (flightBookingSystem.getCustomers().size() > 0) {
                int lastIndex = flightBookingSystem.getCustomers().size() - 1;
                maxId = flightBookingSystem.getCustomers().get(lastIndex).getId();
            }
            
            Customer customer = new Customer(++maxId, name, phone, email);
            flightBookingSystem.addCustomer(customer);
            storeData(flightBookingSystem);
            System.out.println("Customer #" + customer.getId() + " added.");
			
		} catch (FlightBookingSystemException e) {
			// TODO Auto-generated catch block
			throw new FlightBookingSystemException("Error: Unable to save.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }




}
