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



}