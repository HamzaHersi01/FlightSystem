package bcu.cmp5332.bookingsystem.model;



import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {
	
	private final LocalDate date= LocalDate.parse("2022-12-24");
	private final Flight stats = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);

	@Test
	//gets the id of the user
	public void GetIdTest() {
		assertEquals(5, stats.getId());
	}

	private final Flight stats2 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	//sets the id of the user
	@Test
	public void SetIDTest() {
		stats2.setId(3);
		assertEquals(3, stats2.getId());
	}
	
	private final Flight stats3 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	//gets the flight number of the user
	@Test
	public void getFlightNumberTest() {
		assertEquals("DSE1234", stats3.getFlightNumber());
	}
	
	private final Flight stats4 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	//sets the flight number of the user
	@Test
	public void setFlightNumberTest() {
		stats4.setFlightNumber("LLKSH4");
		assertEquals("LLKSH4", stats4.getFlightNumber());
	}
	
	private final Flight stats5 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	//gets the origins of the flight
	@Test
	public void getOrginTest() {
		assertEquals("Dublin", stats5.getOrigin());
	}
	
	private final Flight stats6 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	//sets the origins of the flight
	@Test
	public void setOrginTest() {
		stats6.setOrigin("New York");
		assertEquals("New York", stats6.getOrigin());
	}
	
	private final Flight stats7 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	//gets the destination of the flight
	@Test
	public void getDestinationTest() {
		assertEquals("Moroco", stats7.getDestination());
	}
	
	private final Flight stats8 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	//sets the destination of the fligh
	@Test
	public void setDestinationTest() {
		stats8.setDestination("New York");
		assertEquals("New York", stats8.getDestination());
	}
	
	private final Flight stats9 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	//gets the departure date of the flight
	@Test
	public void getDepartureDateTest() {
		assertEquals(date, stats9.getDepartureDate());
	}
	
	
	private final LocalDate date2 = LocalDate.parse("2022-12-29");
	private final Flight stats10 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	//sets the new departurte date of the flight
	@Test
	public void setDepartureDateTest() {
		stats10.setDepartureDate(date2);
		assertEquals(date2, stats10.getDepartureDate());
	}
	
	private final Flight stats11 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	//gets the max capacity of the flight
	@Test
	public void getFlightCapacityTest() {
		assertEquals(200, stats11.getFlightCapacity());
	}
	
	private final Flight stats12 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	//sets the capaccity of the flight
	@Test
	public void setFlightCapacityTest() {
		stats12.setFlightCapacity(400);
		assertEquals(400, stats12.getFlightCapacity());
	}
	
	private final Flight stats13 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	//gets the price of the flight
	@Test
	public void getPrice() {
		assertEquals(40, stats13.getPrice());
	}
	
	private final Flight stats14 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	//sets the price of the flight
	@Test
	public void setPrice() {
		stats14.setPrice(100);
		assertEquals(100, stats14.getPrice());
	}
	
	public final Flight stats15 = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);
	//gets the passengers of the flight
	@Test
	public void getPassengersTest() {
	System.out.print(stats15.getPassengers());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}