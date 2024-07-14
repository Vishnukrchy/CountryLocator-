package com.vishnu.Assignment;

import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.feature.FeatureCollection;
import org.geotools.geojson.feature.FeatureJSON;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.geometry.BoundingBox;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * CountryLocator class is responsible for determining the country code
 * based on latitude and longitude using geographical boundary data.
 */
public class CountryLocator {
    private List<SimpleFeature> countryFeatures;

    /**
     * Constructs a CountryLocator with the specified GeoJSON file path.
     *
     * @param geoJsonFilePath The path to the GeoJSON file containing country boundaries.
     * @throws IOException If an I/O error occurs reading the GeoJSON file.
     */
    public CountryLocator(String geoJsonFilePath) throws IOException {
        FeatureJSON featureJSON = new FeatureJSON();
        FeatureCollection featureCollection = featureJSON.readFeatureCollection(new File("data/countries.geojson"));
        countryFeatures = new ArrayList<>();
        ((Iterable<SimpleFeature>) featureCollection).forEach(feature -> {
            if (feature instanceof SimpleFeature) {
                countryFeatures.add((SimpleFeature) feature);
            } else {
                System.err.println("Skipping non-SimpleFeature: " + feature.getID());
            }
        });
    }

    /**
     * Returns the ISO 3166-1 alpha-2 country code for the given latitude and longitude.
     *
     * @param latitude  The latitude of the location.
     * @param longitude The longitude of the location.
     * @return The ISO 3166-1 alpha-2 country code, or "Unknown" if the location is not within any country's boundaries.
     */
    public String getCountryCode(double latitude, double longitude) {
        // List of known oceanic coordinates
        if (latitude == 0 && longitude == 0) {
            return "Unknown";
        }
        for (SimpleFeature feature : countryFeatures) {
            BoundingBox bbox = feature.getBounds();
            System.out.println("Checking feature: " + feature.getID() + " with bbox: " + bbox);
            if (bbox.contains(longitude, latitude)) {
                String countryCode = (String) feature.getAttribute("ISO_A2");
                System.out.println("Matched feature: " + feature.getID() + " with country code: " + countryCode);
                if (countryCode != null && !countryCode.isEmpty()) {
                    Locale locale = new Locale("", countryCode);
                    return locale.getCountry();
                }
            }
        }
        return "Unknown";
    }

}
