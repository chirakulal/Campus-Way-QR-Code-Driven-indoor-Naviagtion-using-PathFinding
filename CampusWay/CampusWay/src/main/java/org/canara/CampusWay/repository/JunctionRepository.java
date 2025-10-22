package org.canara.CampusWay.repository;

import org.canara.CampusWay.model.Junction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JunctionRepository extends JpaRepository<Junction, String> {

    Optional<Junction> findById(String id);  // Default findById method

}