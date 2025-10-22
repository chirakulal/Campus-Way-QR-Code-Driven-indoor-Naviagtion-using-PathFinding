package org.canara.CampusWay.repository;

import org.canara.CampusWay.model.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, String> {

    // Custom method to find connections by Junction ID
    List<Connection> findByJunctionId(String junctionId);

    // Custom method to find connections by ConnectedTo ID
    List<Connection> findByConnectedTo(String connectedTo);
}