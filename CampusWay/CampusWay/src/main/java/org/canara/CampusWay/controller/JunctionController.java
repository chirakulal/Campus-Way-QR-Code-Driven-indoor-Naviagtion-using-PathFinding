package org.canara.CampusWay.controller;

import org.canara.CampusWay.model.Junction;
import org.canara.CampusWay.service.JunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/junctions")
public class JunctionController {

    @Autowired
    private JunctionService junctionService;

    // Create or Update a Junction
    @PostMapping
    public ResponseEntity<Junction> createJunction(@RequestBody Junction junction) {
        System.out.println("Received Junction: " + junction); // Debug log
        try {
            Junction savedJunction = junctionService.saveJunction(junction);
            return new ResponseEntity<>(savedJunction, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace(); // Print error details
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Get all Junctions
    @GetMapping
    public ResponseEntity<List<Junction>> getAllJunctions() {
        List<Junction> junctions = junctionService.getAllJunctions();
        return ResponseEntity.ok(junctions);
    }

    // Get Junction by ID
    @GetMapping("/{id}")
    public ResponseEntity<Junction> getJunctionById(@PathVariable String id) {
        Optional<Junction> junction = junctionService.getJunctionById(id);
        return junction.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete Junction by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJunction(@PathVariable String id) {
        Optional<Junction> junction = junctionService.getJunctionById(id);
        if (junction.isPresent()) {
            junctionService.deleteJunction(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
