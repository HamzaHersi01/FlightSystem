package bcu.cmp5332.bookingsystem.main;

import bcu.cmp5332.bookingsystem.commands.LoadGUI;
import bcu.cmp5332.bookingsystem.commands.ShowCustomer;
import bcu.cmp5332.bookingsystem.commands.ShowFlight;
import bcu.cmp5332.bookingsystem.data.FlightDataManager;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;
import bcu.cmp5332.bookingsystem.commands.ListFlights;
import bcu.cmp5332.bookingsystem.commands.AddBooking;
import bcu.cmp5332.bookingsystem.commands.AddCustomer;
import bcu.cmp5332.bookingsystem.commands.AddFlight;
import bcu.cmp5332.bookingsystem.commands.CancelBooking;
import bcu.cmp5332.bookingsystem.commands.CancelFlight;
import bcu.cmp5332.bookingsystem.commands.Command;
import bcu.cmp5332.bookingsystem.commands.Help;
import bcu.cmp5332.bookingsystem.commands.ListCustomers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CommandParser {
    
    public static Command parse(String line) throws IOException, FlightBookingSystemException {
        try {
            String[] parts = line.split(" ", 3);
            String cmd = parts[0];

            //if the parts are 0 and is equal to addlflight a new flight object with data entered by user will be created using the BuffredReader
            if (cmd.equals("addflight")) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Flight Number: ");
                String flighNumber = reader.readLine();
                System.out.print("Origin: ");
                String origin = reader.readLine();
                System.out.print("Destination: ");
                String destination = reader.readLine();
                LocalDate departureDate = parseDateWithAttempts(reader);
                System.out.print("Flight Capacity: ");
                String temp_flightCapacity = reader.readLine();
                System.out.print("Price: ");
                String temp_price= reader.readLine();
                
                int price = Integer.parseInt(temp_price);
                int flightCapacity = Integer.parseInt(temp_flightCapacity);
                

                return new AddFlight(flighNumber, origin, destination, departureDate, flightCapacity, price);
            } 
            //if the parts are 0 and is equal to add customer a new customer object with data entered by user will be created using the BuffredReader
            else if (cmd.equals("addcustomer")) {
            	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Name: ");
                String name = reader.readLine();
                System.out.print("Phone Number: ");
                String phone = reader.readLine();
                System.out.print("Email: ");
                String email = reader.readLine();

                return new AddCustomer(name, phone, email);
                //tje gui will be loaded
            } else if (cmd.equals("loadgui")) {
                return new LoadGUI();
            } else if (parts.length == 1) {
            	//will list all flights that have not yet departed
                if (line.equals("listflights")) {
                    return new ListFlights();
                    //lists all customers
                } else if (line.equals("listcustomers")) {
                	return new ListCustomers();
                	//displays usable commands
                } else if (line.equals("help")) {
                    return new Help();
                }
            } else if (parts.length == 2) {
                int id = Integer.parseInt(parts[1]);
                //will show the details of a flight with entered id or return flight not found
                if (cmd.equals("showflight")) {
                	return new ShowFlight(id);
                    //will display the details of desired customer with entered id else will return customer not found
                } else if (cmd.equals("showcustomer")) {

                    return new ShowCustomer(id);
                  //  will remove the flight
                }else if (cmd.equals("cancelflight")) {
                	return new CancelFlight(id);
                }
            } else if (parts.length == 3) {
            	//saves customer id and flight id to be used by any commmand with 3 parts
            	int customerId = Integer.parseInt(parts[1]);
            	int flightId = Integer.parseInt(parts[2]);
            	//adds a new booking using the inputted data
                if (cmd.equals("addbooking")) {
                	return new AddBooking(customerId, flightId);
                    
                } else if (cmd.equals("editbooking")) {
                 //cancels the booking with the given data   
                } else if (cmd.equals("cancelbooking")) {
                	return new CancelBooking(customerId, flightId);
                    
                }
            }
        } catch (NumberFormatException ex) {

        }

        throw new FlightBookingSystemException("Invalid command.");
    }
    //parses the string inpputed that should be in the correct format into the LocalDate but the user is given 3 attempts to correclty input the date
    //in the corerct format
    private static LocalDate parseDateWithAttempts(BufferedReader br, int attempts) throws IOException, FlightBookingSystemException {
        if (attempts < 1) {
            throw new IllegalArgumentException("Number of attempts should be higher that 0");
        }
        while (attempts > 0) {
            attempts--;
            System.out.print("Departure Date (\"YYYY-MM-DD\" format): ");
            try {
                LocalDate departureDate = LocalDate.parse(br.readLine());
                return departureDate;
            } catch (DateTimeParseException dtpe) {
                System.out.println("Date must be in YYYY-MM-DD format. " + attempts + " attempts remaining...");
            }
        }
        
        throw new FlightBookingSystemException("Incorrect departure date provided. Cannot create flight.");
    }
    
    private static LocalDate parseDateWithAttempts(BufferedReader br) throws IOException, FlightBookingSystemException {
        return parseDateWithAttempts(br, 3);
    }
}
