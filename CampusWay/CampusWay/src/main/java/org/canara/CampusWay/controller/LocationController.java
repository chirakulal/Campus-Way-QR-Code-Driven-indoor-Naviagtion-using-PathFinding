package org.canara.CampusWay.controller;
import org.canara.CampusWay.model.Location;
import org.canara.CampusWay.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    // Get all locations
    @GetMapping
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    // Get a specific location by ID
    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable String id) {
        Optional<Location> location = locationRepository.findById(id);
        return location.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new location
    @PostMapping("/post")
    public Location createLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    // Update an existing location
    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable String id, @RequestBody Location locationDetails) {
        Optional<Location> locationOptional = locationRepository.findById(id);

        if (locationOptional.isPresent()) {
            Location location = locationOptional.get();

            // Update only if the new value is not null
            if (locationDetails.getXCoordinate() != null) {
                location.setXCoordinate(locationDetails.getXCoordinate());
            }
            if (locationDetails.getYCoordinate() != null) {
                location.setYCoordinate(locationDetails.getYCoordinate());
            }
            if (locationDetails.getImages() != null) {
                location.setImages(locationDetails.getImages());
            }

            return ResponseEntity.ok(locationRepository.save(location));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a location
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable String id) {
        Optional<Location> location = locationRepository.findById(id);

        if (location.isPresent()) {
            locationRepository.delete(location.get());
            return ResponseEntity.noContent().build(); // 204 No Content if deletion is successful
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found if location does not exist
        }
    }

}