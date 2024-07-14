package com.vishnu.Assignment;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            CountryLocator locator = new CountryLocator("data/countries.geojson");
            
            // Example latitude and longitude 
            double latitude = 34.5553;
            double longitude = 69.2075;
            
            String countryCode = locator.getCountryCode(latitude, longitude);
            System.out.println("Country Code: " + countryCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
