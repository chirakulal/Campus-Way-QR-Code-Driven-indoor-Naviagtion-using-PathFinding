package org.canara.CampusWay.model;


import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Junctions")
public class Junction {

    @Id
    private String id; // Junction ID

    @JsonProperty("xCoordinate")
    private BigDecimal xCoordinate;
    @JsonProperty("yCoordinate")
    private BigDecimal yCoordinate;

    // Default Constructor
    public Junction() {}

    // Parameterized Constructor
    public Junction(String id, BigDecimal xCoordinate, BigDecimal yCoordinate) {
        this.id = id;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(BigDecimal xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public BigDecimal getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(BigDecimal yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    @Override
    public String toString() {
        return "Junction{" +
                "id='" + id + '\'' +
                ", xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
            '}';
}
}