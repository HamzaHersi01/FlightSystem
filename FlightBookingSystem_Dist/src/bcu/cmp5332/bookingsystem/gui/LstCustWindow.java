package bcu.cmp5332.bookingsystem.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import bcu.cmp5332.bookingsystem.commands.AddFlight;
import bcu.cmp5332.bookingsystem.commands.Command;
import bcu.cmp5332.bookingsystem.commands.ShowFlight;
import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;

public class LstCustWindow extends JFrame implements ActionListener{
	private MainWindow mw;
	private JTextField flightIdText = new JTextField();
	private JLabel showCustLbl = new JLabel("");
//	private JTextField showCustText = new JTextField();
	private JButton subBtn = new JButton("Submit");

	//intitialises the constructor
	 public LstCustWindow(MainWindow mw) {
	        this.mw = mw;
	        initialize();
	    }
	 
	 //creates and initialises the window and add all elements to panels and layouts also adds actionlistener to buttons
     // and sets it to visible
	 private void initialize() {

	        try {
	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        } catch (Exception ex) {

	        }

	        setTitle("List passengers for particular flight");

	        setSize(800, 300);
	        JPanel topPanel = new JPanel();
	        topPanel.setLayout(new GridLayout(3, 1));
	        topPanel.add(new JLabel("Flight Id : "));
	        topPanel.add(flightIdText);
//	        topPanel.add(new JLabel("     "));
	        topPanel.add(subBtn);
//	        topPanel.add(showCustLbl);

	        JPanel bottomPanel = new JPanel();
	        bottomPanel.setLayout(new GridLayout(6, 1));
	        bottomPanel.add(new JLabel("     "));
	        bottomPanel.add(showCustLbl);
//	        bottomPanel.add(showCustText);

	        subBtn.addActionListener(this);

	        this.getContentPane().add(topPanel, BorderLayout.CENTER);
	        this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
	        setLocationRelativeTo(mw);

	        setVisible(true);

	    }
	 
	 	//adds functionality to the submit button
	 	@Override
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			if (ae.getSource() == subBtn) {
	            lstCust();
	        }
			
		}
	 	
	 	//this gets the flight id from the user and converts it to integer which it uses to get flight object
	 	//so it can get the method get details to output details about the flight
	 	//also it sets the output of getdetails to the text of the label to show it in the window interface
	 	private void lstCust() {
	        try {
	            int flightId = Integer.parseInt(flightIdText.getText());
	            // create and execute the Command
//	            Command ShowFlight = new ShowFlight(flightId);
//	            ShowFlight.execute(mw.getFlightBookingSystem());
	            
	            showCustLbl.setText(mw.getFlightBookingSystem().getFlightByID(flightId).getDetails());
	            // refresh the view with the list of flights
//	            mw.displayFlights();
	            // hide (close) the Window
//	            this.setVisible(false);
	        } catch (FlightBookingSystemException ex) {
	            JOptionPane.showMessageDialog(this, ex, "Error", JOptionPane.ERROR_MESSAGE);
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(this, ex, "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }


}
