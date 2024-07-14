package com.vishnu.Assignment;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryLocatorTest {

    @Test
    public void testGetCountryCode() throws IOException {
        CountryLocator locator = new CountryLocator("data/countries.geojson");
        
        // Test for India
        String countryCode = locator.getCountryCode(20.5937, 78.9629); // Coordinates for India
        System.out.println("Expected: IN, Actual: " + countryCode);
        assertEquals("IN", countryCode);

        // Test for USA
        countryCode = locator.getCountryCode(37.7749, -122.4194); // Coordinates for USA (SanFrancisco)
        System.out.println("Expected: US, Actual: " + countryCode);
        assertEquals("US", countryCode);

        // Test for ocean
        countryCode = locator.getCountryCode(0, 0); // Coordinates for ocean
        System.out.println("Expected: Unknown, Actual: " + countryCode);
        assertEquals("Unknown", countryCode);
    }
}
