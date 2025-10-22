package org.canara.CampusWay.repository;

import org.canara.CampusWay.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, String> {

    /**
     * Custom query to find locations by X Coordinate.
     * @param xCoordinate The X coordinate to search by.
     * @return A list of locations matching the given X coordinate.
     */
    @Query("SELECT l FROM Location l WHERE l.xCoordinate = :xCoordinate")
    List<Location> findByXCoordinate(@Param("xCoordinate") Double xCoordinate);

    /**
     * Custom query to find locations by Y Coordinate.
     * @param yCoordinate The Y coordinate to search by.
     * @return A list of locations matching the given Y coordinate.
     */
    @Query("SELECT l FROM Location l WHERE l.yCoordinate = :yCoordinate")
    List<Location> findByYCoordinate(@Param("yCoordinate") Double yCoordinate);

    /**
     * Custom query to find locations within a specific range of X and Y coordinates.
     * @param xMin The minimum X coordinate.
     * @param xMax The maximum X coordinate.
     * @param yMin The minimum Y coordinate.
     * @param yMax The maximum Y coordinate.
     * @return A list of locations within the given range.
     */
    @Query("SELECT l FROM Location l WHERE l.xCoordinate BETWEEN :xMin AND :xMax AND l.yCoordinate BETWEEN :yMin AND :yMax")
    List<Location> findLocationsInRange(@Param("xMin") Double xMin, @Param("xMax") Double xMax, @Param("yMin") Double yMin, @Param("yMax") Double yMax);
}