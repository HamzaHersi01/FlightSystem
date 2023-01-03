package bcu.cmp5332.bookingsystem.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class FlightTest {
	
	private final LocalDate date= LocalDate.parse("2022-12-24");
	private final Flight stats = new Flight(5, "DSE1234", "Dublin", "Moroco",date,200, 40);

	@Test
	public void GetIdTest() {
		assetEquals(5,stats.getId());
	}

}
