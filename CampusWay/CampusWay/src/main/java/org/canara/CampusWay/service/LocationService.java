package org.canara.CampusWay.service;

import org.canara.CampusWay.model.Location;
import org.canara.CampusWay.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    // Get all locations
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    // Get a specific location by ID
    public Optional<Location> getLocationById(String id) {
        return locationRepository.findById(id);
    }

    // Create a new location
    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    // Update an existing location
    public Optional<Location> updateLocation(String id, Location locationDetails) {
        return locationRepository.findById(id).map(location -> {
            location.setXCoordinate(locationDetails.getXCoordinate());
            location.setYCoordinate(locationDetails.getYCoordinate());
            location.setImages(locationDetails.getImages());
            return locationRepository.save(location);
        });
    }

    public boolean deleteLocation(String id) {
        // Check if location exists
        if (locationRepository.existsById(id)) {
            // Delete the location by ID
            locationRepository.deleteById(id);
            return true; // Return true if the location was deleted successfully
        }
        return false; // Return false if the location was not found
    }
}