package bcu.cmp5332.bookingsystem.gui;

import bcu.cmp5332.bookingsystem.data.FlightBookingSystemData;
import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Customer;
import bcu.cmp5332.bookingsystem.model.Flight;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainWindow extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu adminMenu;
    private JMenu flightsMenu;
    private JMenu bookingsMenu;
    private JMenu customersMenu;

    private JMenuItem adminExit;

    private JMenuItem flightsView;
    private JMenuItem flightsAdd;
    private JMenuItem flightsDel;
    
    private JMenuItem bookingsIssue;
    private JMenuItem bookingsUpdate;
    private JMenuItem bookingsCancel;

    private JMenuItem custView;
    private JMenuItem custAdd;
    private JMenuItem custDel;
    private JMenuItem lstCust;

    private FlightBookingSystem fbs;

    public MainWindow(FlightBookingSystem fbs) {

        initialize();
        this.fbs = fbs;
    }
    
    public FlightBookingSystem getFlightBookingSystem() {
        return fbs;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {

        }

        setTitle("Flight Booking Management System");

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        //adding adminMenu menu and menu items
        //gives you the option to exit gui using admin exit
        adminMenu = new JMenu("Admin");
        menuBar.add(adminMenu);

        adminExit = new JMenuItem("Exit");
        adminMenu.add(adminExit);
        adminExit.addActionListener(this);

        // adding Flights menu and menu items
        //allows you to view, add,delete a  flight through gui
        flightsMenu = new JMenu("Flights");
        menuBar.add(flightsMenu);

        flightsView = new JMenuItem("View");
        flightsAdd = new JMenuItem("Add");
        flightsDel = new JMenuItem("Delete");
        flightsMenu.add(flightsView);
        flightsMenu.add(flightsAdd);
        flightsMenu.add(flightsDel);
        // adding action listener for Flights menu items
        for (int i = 0; i < flightsMenu.getItemCount(); i++) {
            flightsMenu.getItem(i).addActionListener(this);
        }
        
        // adding Bookings menu and menu items
        //allows you to issue,update and cancel a booking through gui
        bookingsMenu = new JMenu("Bookings");
        
        bookingsIssue = new JMenuItem("Issue");
        bookingsUpdate = new JMenuItem("Update");
        bookingsCancel = new JMenuItem("Cancel");
        bookingsMenu.add(bookingsIssue);
        bookingsMenu.add(bookingsUpdate);
        bookingsMenu.add(bookingsCancel);
        // adding action listener for Bookings menu items
        for (int i = 0; i < bookingsMenu.getItemCount(); i++) {
            bookingsMenu.getItem(i).addActionListener(this);
        }

        // adding Customers menu and menu items
        //allows you to view, add, delete,list passengers through gui
        customersMenu = new JMenu("Customers");
        menuBar.add(customersMenu);

        custView = new JMenuItem("View");
        custAdd = new JMenuItem("Add");
        custDel = new JMenuItem("Delete");
        lstCust = new JMenuItem("List Passengers");

        customersMenu.add(custView);
        customersMenu.add(custAdd);
        customersMenu.add(custDel);
        customersMenu.add(lstCust);
        // adding action listener for Customers menu items
        //performs the respective action for which option is selected
        custView.addActionListener(this);
        custAdd.addActionListener(this);
        custDel.addActionListener(this);
        lstCust.addActionListener(this);
        //sests the size of the box
        setSize(800, 500);

        setVisible(true);
        setAutoRequestFocus(true);
        toFront();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
/* Uncomment the following line to not terminate the console app when the window is closed */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);        

    }	

/* Uncomment the following code to run the GUI version directly from the IDE */
//    public static void main(String[] args) throws IOException, FlightBookingSystemException {
//        FlightBookingSystem fbs = FlightBookingSystemData.load();
//        new MainWindow(fbs);			
//    }



    @Override
    public void actionPerformed(ActionEvent ae) {
    	//exits the gui if exit is selected and saves before hand
        if (ae.getSource() == adminExit) {
            try {
                FlightBookingSystemData.store(fbs);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
            System.exit(0);
            //will display the flights if flightsview is selcted
        } else if (ae.getSource() == flightsView) {
            displayFlights();
            //will allows you to add a flight by creating a pop up window with the input fields for a flight
        } else if (ae.getSource() == flightsAdd) {
            new AddFlightWindow(this);
            //allows you to delete a flight
        } else if (ae.getSource() == flightsDel) {
//        	new DelFlightWindow(this);
            //allows you to issue a new booking
        } else if (ae.getSource() == bookingsIssue) {
            
           //allows you to cancel booking 
        } else if (ae.getSource() == bookingsCancel) {
            
          //allows you to view a customers  
        } else if (ae.getSource() == custView) {
        	displayCust();
          //allows you to add a new customer  
        } else if (ae.getSource() == custAdd) {
        	new AddCustWindow(this);
            
            //allows you to delete a customer
        } else if (ae.getSource() == custDel) {
            
           //allows you to list all customers
        } else if (ae.getSource() == lstCust) {
        	new LstCustWindow(this);
            
        } 
        
        
        
    }
    //prevents cells form being edited
    public boolean isCellEditable(int row, int col) {
    	if (col == 7) {
    	            return true;
    	        } else {
    	            return false;
    	        }       
    	    }
//shows the flights by using the respective getters
    public void displayFlights() {
        List<Flight> flightsList = fbs.getFlights();
        // headers for the table
        String[] columns = new String[]{"Flight No", "Origin", "Destination", "Departure Date","Flight Capacity", "Price"};

        Object[][] data = new Object[flightsList.size()][6];
        for (int i = 0; i < flightsList.size(); i++) {
            Flight flight = flightsList.get(i);
            data[i][0] = flight.getFlightNumber();
            data[i][1] = flight.getOrigin();
            data[i][2] = flight.getDestination();
            data[i][3] = flight.getDepartureDate();
            data[i][4] = flight.getFlightCapacity();
            data[i][5] = flight.getPrice();
            
        }
//creates the jtable from the data and coloumn objects
        JTable table = new JTable(data, columns);
        this.getContentPane().removeAll();
        this.getContentPane().add(new JScrollPane(table));
        this.revalidate();
    }
    //dispalys the customer and their respective attributes
    public void displayCust() {
//    	JButton custBtn = new JButton("Booking details");
        List<Customer> custList = fbs.getCustomers();
//        custBtn.addActionListener(this);
//        List<Bookings> bookings = fbs.getCustomers();
        // headers for the table
        String[] columns = new String[]{"Name", "Phone", "Email", "No of Bookings"};

        Object[][] data = new Object[custList.size()][4];
        
        for (int i = 0; i < custList.size(); i++) {
            Customer customer = custList.get(i);
            data[i][0] = customer.getName();
            data[i][1] = customer.getPhone();
            data[i][2] = customer.getEmail();
            data[i][3] = customer.getBookings().size();
            
            
        }
        
        //creates a new jtable from the data and coloumn obkcts
        JTable table = new JTable(data, columns);
        this.getContentPane().removeAll();
        this.getContentPane().add(new JScrollPane(table));
        this.revalidate();
        table.setDefaultEditor(Object.class, null);
        
        ListSelectionModel model = table.getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener() {
        	//shows the booking of a customer if they are selected
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(!model.isSelectionEmpty()) {
					try {
						int rowSelected = model.getMinSelectionIndex();
						JOptionPane.showMessageDialog(null, fbs.getCustomerByID(rowSelected+1).getDetailsLong());
					} catch (FlightBookingSystemException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
        	
        });
        
    }
    
    
//    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                 
//        	   JTable source = (JTable)evt.getSource();
//               int row = source.rowAtPoint( evt.getPoint() );
//               int column = source.columnAtPoint( evt.getPoint() );
//               String s=source.getModel().getValueAt(row, column)+"";
//
//               JOptionPane.showMessageDialog(null, s);
//   }
}
