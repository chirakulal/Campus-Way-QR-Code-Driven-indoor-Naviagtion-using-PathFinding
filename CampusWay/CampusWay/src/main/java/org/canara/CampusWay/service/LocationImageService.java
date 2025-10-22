package org.canara.CampusWay.service;


import org.canara.CampusWay.model.Location;
import org.canara.CampusWay.model.LocationImage;
import org.canara.CampusWay.repository.LocationImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationImageService {

    private final LocationImageRepository locationImageRepository;

    public LocationImageService(LocationImageRepository locationImageRepository) {
        this.locationImageRepository = locationImageRepository;
    }

    // Fetch all location images
    public List<LocationImage> getAllLocationImages() {
        return locationImageRepository.findAll();
    }

    // Fetch location images by location ID
    public List<Location> getImagesByLocationId(String locationId) {
        return locationImageRepository.findByLocationId(locationId);
    }

    // Fetch a location image by its ID
    public Optional<LocationImage> getLocationImageById(Long id) {
        return locationImageRepository.findById(id);
    }

    // Save or update a location image
    public LocationImage saveLocationImage(LocationImage locationImage) {
        return locationImageRepository.save(locationImage);
    }

    // Delete a location image by ID
    public void deleteLocationImage(Long id) {
        if (!locationImageRepository.existsById(id)) {
            throw new IllegalArgumentException("LocationImage with ID " + id + " does not exist.");
        }
        locationImageRepository.deleteById(id);
    }

}
