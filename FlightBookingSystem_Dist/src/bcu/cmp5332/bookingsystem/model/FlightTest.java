package bcu.cmp5332.bookingsystem.model;



import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {
	
	private final LocalDate date= LocalDate.parse("2022-12-24");
	private final Flight stats = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);

	@Test
	public void GetIdTest() {
		assertEquals(5, stats.getId());
	}

	private final Flight stats2 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	@Test
	public void SetIDTest() {
		stats2.setId(3);
		assertEquals(3, stats2.getId());
	}
	
	private final Flight stats3 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	@Test
	public void getFlightNumberTest() {
		assertEquals("DSE1234", stats3.getFlightNumber());
	}
	
	private final Flight stats4 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	@Test
	public void setFlightNumberTest() {
		stats4.setFlightNumber("LLKSH4");
		assertEquals("LLKSH4", stats4.getFlightNumber());
	}
	
	private final Flight stats5 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	@Test
	public void getOrginTest() {
		assertEquals("Dublin", stats5.getOrigin());
	}
	
	private final Flight stats6 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	@Test
	public void setOrginTest() {
		stats6.setOrigin("New York");
		assertEquals("New York", stats6.getOrigin());
	}
	
	private final Flight stats7 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	@Test
	public void getDestinationTest() {
		assertEquals("Moroco", stats7.getDestination());
	}
	
	private final Flight stats8 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	@Test
	public void setDestinationTest() {
		stats8.setDestination("New York");
		assertEquals("New York", stats8.getDestination());
	}
	
	private final Flight stats9 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	@Test
	public void getDepartureDate() {
		assertEquals("2022-12-24", stats9.getDepartureDate());
	}
	
	
	
	
	
	
	
}