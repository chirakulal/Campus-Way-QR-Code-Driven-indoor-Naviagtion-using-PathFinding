package org.canara.CampusWay.repository;


import org.canara.CampusWay.model.Location;
import org.canara.CampusWay.model.LocationImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationImageRepository extends JpaRepository<LocationImage, Long> {
    // Custom query to find images by location ID
	List<Location> findByLocationId(String locationId);
}