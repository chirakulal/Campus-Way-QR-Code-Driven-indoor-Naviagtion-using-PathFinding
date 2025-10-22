package org.canara.CampusWay.model;

import jakarta.persistence.*;

@Entity
@Table(name = "LocationImage")
public class LocationImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String location_image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    // Default Constructor
    public LocationImage() {}

    // Parameterized Constructor
    public LocationImage(String imagePath, Location location) {
        this.location_image = imagePath;
        this.location = location;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagePath() {
        return location_image;
    }

    public void setImagePath(String imagePath) {
        this.location_image = imagePath;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "LocationImage{" +
                "id=" + id +
                ", imagePath='" + location_image + '\'' +
                ", location=" + (location != null ? location.getId() : null) +
                '}';
    }

}
