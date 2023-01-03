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
}