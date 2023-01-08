package bcu.cmp5332.bookingsystem.data;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;
import java.io.IOException;

public interface DataManager {
	//this is a interface data manager that has a constant seperator and loaddata and store data methods
	//used by all classes that implement the datamanager and it is required 
    
    public static final String SEPARATOR = "::";
    
    public void loadData(FlightBookingSystem fbs) throws IOException, FlightBookingSystemException;
    public void storeData(FlightBookingSystem fbs) throws IOException;
    
}
