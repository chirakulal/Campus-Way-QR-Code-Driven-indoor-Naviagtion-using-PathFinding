package org.canara.CampusWay.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConnectionDTO {

    private Long id;

    @JsonProperty("junction_id")
    private String junctionId;

    @JsonProperty("connected_to")
    private String connectedTo;

    // Default Constructor
    public ConnectionDTO() {}

    // Parameterized Constructor
    public ConnectionDTO(Long id, String junctionId, String connectedTo) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ConnectionDTO{" +
                "id=" + id +
                ", junctionId='" + junctionId + '\'' +
                ", connectedTo='" + connectedTo + '\'' +
'}';
}
}