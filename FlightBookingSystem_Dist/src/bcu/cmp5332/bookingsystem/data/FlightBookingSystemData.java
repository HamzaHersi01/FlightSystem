package bcu.cmp5332.bookingsystem.data;



import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlightBookingSystemData {
    
    private static final List<DataManager> dataManagers = new ArrayList<>();
    
    // runs only once when the object gets loaded to memory
    static {
        dataManagers.add(new FlightDataManager());
        
        /* Uncomment the two lines below when the implementation of their 
        loadData() and storeData() methods is complete */
         dataManagers.add(new CustomerDataManager());
         dataManagers.add(new BookingDataManager());
    }
    
    public static FlightBookingSystem load() throws FlightBookingSystemException, IOException {
    	
    	//loads data from the data managers and returns a fbs with the data loaded
        FlightBookingSystem fbs = new FlightBookingSystem();
        for (DataManager dm : dataManagers) {
            dm.loadData(fbs);
        }
        return fbs;
    }

    public static void store(FlightBookingSystem fbs) throws IOException {
    	
    	//stores data from data managers
        for (DataManager dm : dataManagers) {
            dm.storeData(fbs);
        }
    }
    
}
