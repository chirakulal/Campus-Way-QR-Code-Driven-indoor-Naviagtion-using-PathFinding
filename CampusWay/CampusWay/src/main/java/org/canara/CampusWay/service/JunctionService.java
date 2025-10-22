package org.canara.CampusWay.service;

import org.canara.CampusWay.model.Junction;
import org.canara.CampusWay.repository.JunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JunctionService {

    @Autowired
    private JunctionRepository junctionRepository;

    // Create or Update a Junction
    public Junction saveJunction(Junction junction) {
        return junctionRepository.save(junction);
    }

    // Get all Junctions
    public List<Junction> getAllJunctions() {
        return junctionRepository.findAll();
    }

    // Get Junction by ID
    public Optional<Junction> getJunctionById(String id) {
        return junctionRepository.findById(id);
    }

    // Delete Junction by ID
    public void deleteJunction(String id) {
        junctionRepository.deleteById(id);
    }
}