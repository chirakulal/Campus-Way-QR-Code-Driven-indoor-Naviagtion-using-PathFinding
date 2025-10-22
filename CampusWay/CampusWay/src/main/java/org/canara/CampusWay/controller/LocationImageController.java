package org.canara.CampusWay.controller;


import org.canara.CampusWay.model.Location;
import org.canara.CampusWay.model.LocationImage;
import org.canara.CampusWay.service.LocationImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/navigation/location-images")
public class LocationImageController {

    private final LocationImageService locationImageService;

    public LocationImageController(LocationImageService locationImageService) {
        this.locationImageService = locationImageService;
    }

    // GET: Fetch all location images
    @GetMapping
    public ResponseEntity<List<LocationImage>> getAllLocationImages() {
        List<LocationImage> images = locationImageService.getAllLocationImages();
        return ResponseEntity.ok(images);
    }

    // GET: Fetch images by location ID
    @GetMapping("/location/{locationId}")
    public ResponseEntity<List<Location>> getImagesByLocationId(@PathVariable String locationId) {
        List<Location> images = locationImageService.getImagesByLocationId(locationId);
        return ResponseEntity.ok(images);
    }

    // GET: Fetch a single location image by ID
    @GetMapping("/{id}")
    public ResponseEntity<LocationImage> getLocationImageById(@PathVariable Long id) {
        return locationImageService.getLocationImageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: Add a new location image
    @PostMapping
    public ResponseEntity<LocationImage> addLocationImage(@RequestBody LocationImage locationImage) {
        LocationImage savedImage = locationImageService.saveLocationImage(locationImage);
        return ResponseEntity.ok(savedImage);
    }

    // PUT: Update an existing location image
    @PutMapping("/{id}")
    public ResponseEntity<LocationImage> updateLocationImage(@PathVariable Long id, @RequestBody LocationImage locationImage) {
        if (!id.equals(locationImage.getId())) {
            return ResponseEntity.badRequest().build();
        }
        LocationImage updatedImage = locationImageService.saveLocationImage(locationImage);
        return ResponseEntity.ok(updatedImage);
    }

    // DELETE: Delete a location image by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocationImage(@PathVariable Long id) {
        try {
            locationImageService.deleteLocationImage(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
