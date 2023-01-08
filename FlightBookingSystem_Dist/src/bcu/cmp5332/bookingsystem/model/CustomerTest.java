package bcu.cmp5332.bookingsystem.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertEquals;

class CustomerTest {
	private final Customer customer = new Customer(7,"Lord of Cinders","01213141","LordOfCinders@mail.souls.uk");
	//gets the id and it should be 7
	@Test
	public void getID() {
		assertEquals(7,customer.getId());
	} 
	//sets the id and should be 10 when it is retreived
	@Test
	public void setID() {
		customer.setId(10);
		assertEquals(10,customer.getId());
	} 
	//gets name and should be Lord of Cinders
	@Test
	public void getname() {
		
		assertEquals("Lord of Cinders",customer.getName());
	} 
	//sets name and should Gwyn Lord of Cinders
	@Test
	public void setname() {
		customer.setName("Gwyn Lord of Cinders");
		assertEquals("Gwyn Lord of Cinders",customer.getName());
	} 
	//gets the phone of the customer and should be 01213141
	@Test
	public void getPhone() {
		
		assertEquals("01213141",customer.getPhone());
	} 
	//sets phone to 012169420
	@Test
	public void setPhone() {
		customer.setPhone("012169420");
		assertEquals("012169420",customer.getPhone());
	} 
	//gets the email of the user and should be LordOfCinders@mail.souls.uk
	@Test
	public void getEmail() {
		
		assertEquals("LordOfCinders@mail.souls.uk",customer.getEmail());
	} 
	//sets email of the user to plin plin plom@mail
	@Test
	public void setEmail() {
		customer.setEmail("plin plin plom@mail");
		assertEquals("plin plin plom@mail",customer.getEmail());
	} 
	//gets the shortened details of the user
	@Test
	public void getDetailsShort() {
		
		assertEquals("Customer #" + customer.getId() + " - " + customer.getName() + " - " + customer.getPhone() + " - "  + customer.getEmail(),customer.getDetailsShort());
	} 
	//gets the long details of the user
	@Test
	public void getDetailsLong() {
		assertEquals("Customer #" + customer.getId() + "\n" + "Name: " + customer.getName() + "\n" + "Phone: " + customer.getPhone() +" -  Email: "+ customer.getEmail() +"\n" 
        		+ "--------------------------" + "\n" + "there are no bookings for this customer",customer.getDetailsLong());
	}


	
	
	
	
	
	
	
	

}
