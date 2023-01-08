package bcu.cmp5332.bookingsystem.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class DelCustWindow extends JFrame implements ActionListener{
	private MainWindow mw;
    private JTextField custIdText = new JTextField();
    
    private JButton subBtn = new JButton("Submit");
    private JButton cancelBtn = new JButton("Cancel");

    public DelCustWindow(MainWindow mw) {
        this.mw = mw;
        initialize();
    }

    private void initialize() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {

        }

        setTitle("Delete Customer");

        setSize(350, 220);
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(5, 2));
        topPanel.add(new JLabel("Customer Id : "));
        topPanel.add(custIdText);    

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 3));
        bottomPanel.add(new JLabel("     "));
        bottomPanel.add(subBtn);
        bottomPanel.add(cancelBtn);

        subBtn.addActionListener(this);
        cancelBtn.addActionListener(this);

        this.getContentPane().add(topPanel, BorderLayout.CENTER);
        this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        setLocationRelativeTo(mw);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == subBtn) {
            delCust();
        } else if (ae.getSource() == cancelBtn) {
            this.setVisible(false);
        }

    }
    //doesnt do anything for now need delete flight method thing.
    private void delCust() {
//        try {
//        	int flightId = Integer.parseInt(flightIdText.getText());
//          
//          
//            // create and execute the del flight Command
//        	mw.getFlightBookingSystem().getFlightByID(flightId);
////            Command addCust = new AddCustomer(name, phone, email);
////            addCust.execute(mw.getFlightBookingSystem());
//            // refresh the view with the list of flights
//            mw.displayFlights();
//            // hide (close) the Window
//            this.setVisible(false);
//        } catch (FlightBookingSystemException ex) {
//            JOptionPane.showMessageDialog(this, ex, "Error", JOptionPane.ERROR_MESSAGE);
//        } catch (NumberFormatException ex) {
//            JOptionPane.showMessageDialog(this, ex, "Error", JOptionPane.ERROR_MESSAGE);
//        }
    }

}
