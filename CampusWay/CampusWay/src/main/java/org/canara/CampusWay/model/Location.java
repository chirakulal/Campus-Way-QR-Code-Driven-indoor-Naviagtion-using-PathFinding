package org.canara.CampusWay.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Locations")
public class Location {

    @Id
    private String id;

    @Column(name = "x_coordinate" ,nullable = false)
    @JsonProperty("x_coordinate")
    private Double xCoordinate;

    @Column(name = "y_coordinate",nullable = false)
    @JsonProperty("y_coordinate")
    private Double yCoordinate;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LocationImage> images;

    // Default Constructor
    public Location() {}

    // Parameterized Constructor
    public Location(String id, Double xCoordinate, Double yCoordinate, List<LocationImage> images) {
        this.id = id;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.images = images;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(Double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Double getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(Double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public List<LocationImage> getImages() {
        return images;
    }

    public void setImages(List<LocationImage> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                ", images=" + (images != null ? images.size() + " images" : "null") +
                '}';
    }
}
