package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

public class Help implements Command {

    @Override
    public void execute(FlightBookingSystem flightBookingSystem) {
    	//prints out the help message showing the commands and description 
        System.out.println(Command.HELP_MESSAGE);
    }
}
