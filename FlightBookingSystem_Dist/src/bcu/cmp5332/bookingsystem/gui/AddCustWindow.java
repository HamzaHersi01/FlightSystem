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
import javax.swing.JTextField;
import javax.swing.UIManager;

import bcu.cmp5332.bookingsystem.commands.AddCustomer;
import bcu.cmp5332.bookingsystem.commands.AddFlight;
import bcu.cmp5332.bookingsystem.commands.Command;
import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;

public class AddCustWindow extends JFrame implements ActionListener{
	//defines the attributes of the addcustwindow class where it has 3 txt fields and 2 buttons and a main window
	private MainWindow mw;
    private JTextField nameText = new JTextField();
    private JTextField phoneText = new JTextField();
    private JTextField emailText = new JTextField();
    
    private JButton addBtn = new JButton("Add");
    private JButton cancelBtn = new JButton("Cancel");

    //initialises the mainwindow attribute and runs the initialize method
    public AddCustWindow(MainWindow mw) {
        this.mw = mw;
        initialize();
    }

    //creates the window by setting the size and title of window and added all the elements like labels and txt fields to the panels
    //which is a grid layout
    //also adds actionlistener to buttons and sets it to visible
    private void initialize() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {

        }

        setTitle("Add a New Customer");

        setSize(350, 220);
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(5, 2));
        topPanel.add(new JLabel("Name : "));
        topPanel.add(nameText);
        topPanel.add(new JLabel("Phone : "));
        topPanel.add(phoneText);
        topPanel.add(new JLabel("email : "));
        topPanel.add(emailText);     

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 3));
        bottomPanel.add(new JLabel("     "));
        bottomPanel.add(addBtn);
        bottomPanel.add(cancelBtn);

        addBtn.addActionListener(this);
        cancelBtn.addActionListener(this);

        this.getContentPane().add(topPanel, BorderLayout.CENTER);
        this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        setLocationRelativeTo(mw);

        setVisible(true);

    }

    //adds funcitonality to the buttons
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addBtn) {
            addCust();
        } else if (ae.getSource() == cancelBtn) {
            this.setVisible(false);
        }

    }
    
    //adds customer using the addcustomer command
    private void addCust() {
        try {
            String name = nameText.getText();
            String phone = phoneText.getText();
            String email = emailText.getText();
          
          
            // create and execute the add customer Command
            Command addCust = new AddCustomer(name, phone, email);
            addCust.execute(mw.getFlightBookingSystem());
            // refresh the view with the list of flights
            mw.displayCust();
            // hide (close) the AddFlightWindow
            this.setVisible(false);
        } catch (FlightBookingSystemException ex) {
            JOptionPane.showMessageDialog(this, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
