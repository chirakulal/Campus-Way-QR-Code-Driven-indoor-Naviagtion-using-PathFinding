package org.canara.CampusWay.service;

import org.canara.CampusWay.model.Connection;
import org.canara.CampusWay.repository.ConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConnectionService {

    private final ConnectionRepository connectionRepository;

    @Autowired
    public ConnectionService(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    // Get all connections
    public List<Connection> getAllConnections() {
        return connectionRepository.findAll();
    }

    // Find connection by junction ID
    public List<Connection> findByJunctionId(String junctionId) {
        return connectionRepository.findByJunctionId(junctionId);
    }

    // Find connection by connectedTo ID
    public List<Connection> findByConnectedTo(String connectedTo) {
        return connectionRepository.findByConnectedTo(connectedTo);
    }

    // Find connection by ID
    public Optional<Connection> findById(String id) {
        return connectionRepository.findById(id);
    }

   
    public Connection saveConnection(Connection connection) {
        return connectionRepository.save(connection);
    }
    // Delete a connection
    public boolean deleteConnection(String id) {
        if (connectionRepository.existsById(id)) {
            connectionRepository.deleteById(id);
            return true;
        }
        return false;
 }
}