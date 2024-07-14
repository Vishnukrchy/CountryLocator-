package com.vishnu.Assignment;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PerformanceTest {

	@Test
	public void testPerformance() throws IOException {
		CountryLocator locator = new CountryLocator("data/countries.geojson"); 
																				

		long totalTime = 0;
		int requests = 100;

		for (int i = 0; i < requests; i++) {
			long startTime = System.nanoTime();
			locator.getCountryCode(20.5937, 78.9629);
			long endTime = System.nanoTime();
			totalTime += (endTime - startTime);
		}

		double averageTime = totalTime / (double) requests;
		System.out.println("Average execution time: " + averageTime + " ns");
	}
}
