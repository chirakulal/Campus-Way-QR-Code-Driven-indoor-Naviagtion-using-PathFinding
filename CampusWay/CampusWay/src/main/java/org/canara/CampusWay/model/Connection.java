package org.canara.CampusWay.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Connections")
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Unique primary key

    @Column(name = "junction_id")
    private String junctionId;

    @Column(name = "connected_to")
    private String connectedTo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "junction_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Junction junction;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "connected_to", referencedColumnName = "id", insertable = false, updatable = false)
    private Junction connectedToJunction;

    // Default Constructor
    public Connection() {}

    // Parameterized Constructor
    public Connection(String junctionId, String connectedTo) {
        this.junctionId = junctionId;
        this.connectedTo = connectedTo;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJunctionId() {
        return junctionId;
    }

    public void setJunctionId(String junctionId) {
        this.junctionId = junctionId;
    }

    public String getConnectedTo() {
        return connectedTo;
    }

    public void setConnectedTo(String connectedTo) {
        this.connectedTo = connectedTo;
    }

    public Junction getJunction() {
        return junction;
    }

    public void setJunction(Junction junction) {
        this.junction = junction;
    }

    public Junction getConnectedToJunction() {
        return connectedToJunction;
    }

    public void setConnectedToJunction(Junction connectedToJunction) {
        this.connectedToJunction = connectedToJunction;
    } 

    @Override
    public String toString() {
        return "Connection{" +
                "id=" + id +
                ", junctionId='" + junctionId + '\'' +
                ", connectedTo='" + connectedTo + '\'' +
                '}';
    }
}
