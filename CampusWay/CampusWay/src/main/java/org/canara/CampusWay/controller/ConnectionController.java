package org.canara.CampusWay.controller;

import org.canara.CampusWay.model.Connection;
import org.canara.CampusWay.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/connections")
public class ConnectionController {

    private final ConnectionService connectionService;

    @Autowired
    public ConnectionController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    // Get all connections
    @GetMapping
    public ResponseEntity<List<Connection>> getAllConnections() {
        List<Connection> connections = connectionService.getAllConnections();
        return ResponseEntity.ok(connections);
    }

    // Find connections by junction ID
    @GetMapping("/junction/{junctionId}")
    public ResponseEntity<List<Connection>> findByJunctionId(@PathVariable String junctionId) {
        List<Connection> connections = connectionService.findByJunctionId(junctionId);
        return ResponseEntity.ok(connections);
    }

    // Find connections by connectedTo ID
    @GetMapping("/connectedTo/{connectedTo}")
    public ResponseEntity<List<Connection>> findByConnectedTo(@PathVariable String connectedTo) {
        List<Connection> connections = connectionService.findByConnectedTo(connectedTo);
        return ResponseEntity.ok(connections);
    }

    // Find a connection by ID
    @GetMapping("/{id}")
    public ResponseEntity<Connection> findById(@PathVariable String id) {
        Optional<Connection> connection = connectionService.findById(id);
        return connection.map(ResponseEntity::ok)
                         .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/connections")
    public ResponseEntity<Connection> createConnection(@RequestBody Connection connection) {
        System.out.println("Received Connection: " + connection);
        Connection savedConnection = connectionService.saveConnection(connection);
        return ResponseEntity.ok(savedConnection);
    }

    // Delete a connection
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConnection(@PathVariable String id) {
        boolean isDeleted = connectionService.deleteConnection(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
}
}