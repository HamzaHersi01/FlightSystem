package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Flight;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;
import bcu.cmp5332.bookingsystem.data.DataManager;
import bcu.cmp5332.bookingsystem.data.FlightDataManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class CancelFlight implements  Command {
	private final int id;


    private final String RESOURCE = "./resources/data/flights.txt";
    
    public CancelFlight(int id) {
    	this.id= id;
    
    }
    
//	@Override
//    public void loadData(FlightBookingSystem fbs) throws IOException, FlightBookingSystemException {
//        try (Scanner sc = new Scanner(new File(RESOURCE))) {
//            int line_idx = 1;
//            while (sc.hasNextLine()) {
//                String line = sc.nextLine();
//                String[] properties = line.split(SEPARATOR, -1);
//                try {
//                    int id = Integer.parseInt(properties[0]);
//                    String flightNumber = properties[1];
//                    String origin = properties[2];
//                    String destination = properties[3];
//                    LocalDate departureDate = LocalDate.parse(properties[4]);
//                    int flightCapacity = Integer.parseInt(properties[5]);
//                    int price = Integer.parseInt(properties[6]);
//                    boolean removed = Boolean.parseBoolean(properties[7]);
//                    Flight flight = new Flight(id, flightNumber, origin, destination, departureDate, flightCapacity, price);
//                   // if (removed == false) {
//                    fbs.addFlight(flight);
//                   // }
//                } catch (NumberFormatException ex) {
//                    throw new FlightBookingSystemException("Unable to parse book id " + properties[0] + " on line " + line_idx
//                        + "\nError: " + ex);
//                }
//                line_idx++;
//            }
//        }
//    }
//
//	@Override
//    public void storeData(FlightBookingSystem fbs) throws IOException {
//        try (PrintWriter out = new PrintWriter(new FileWriter(RESOURCE))) {
//            for (Flight flight : fbs.getFlights()) {
//                out.print(flight.getId() + SEPARATOR);
//                out.print(flight.getFlightNumber() + SEPARATOR);
//                out.print(flight.getOrigin() + SEPARATOR);
//                out.print(flight.getDestination() + SEPARATOR);
//                out.print(flight.getDepartureDate() + SEPARATOR);
//                out.print(flight.getFlightCapacity() + SEPARATOR);
//                out.print(flight.getPrice() + SEPARATOR);
//                out.print(flight.getRemoved() + SEPARATOR);
//                out.println();
//            }
//        }
//    }
    
	@Override
    public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
     
//        try {
//        	flightBookingSystem.removeFlight(id);
//			FlightDataManager.storeData(flightBookingSystem);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		flightBookingSystem.removeFlight(id);
        System.out.println("Flight #" +id  + " removed.");
    	
    		
    	
    	
        
        
    }


}
