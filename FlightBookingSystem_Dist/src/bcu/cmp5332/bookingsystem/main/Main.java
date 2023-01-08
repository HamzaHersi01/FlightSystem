package bcu.cmp5332.bookingsystem.main;

import bcu.cmp5332.bookingsystem.data.FlightBookingSystemData;
import bcu.cmp5332.bookingsystem.commands.Command;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, FlightBookingSystemException {
        //loads all the data from the datamanagers and stores it in fbsdatamanager
        FlightBookingSystem fbs = FlightBookingSystemData.load();

        //allows for user to input into the console
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //while loop that allows for the user to input and reads the line
        //it then parses that users command into command parser and at the end of the program it stores all data
        System.out.println("Flight Booking System");
        System.out.println("Enter 'help' to see a list of available commands.");
        while (true) {
            System.out.print("> ");
            String line = br.readLine();
            if (line.equals("exit")) {
                break;
            }

            try {
                Command command = CommandParser.parse(line);
                command.execute(fbs);
            } catch (FlightBookingSystemException ex) {
                System.out.println(ex.getMessage());
            }
        }
        FlightBookingSystemData.store(fbs);
        System.exit(0);
    }
}
