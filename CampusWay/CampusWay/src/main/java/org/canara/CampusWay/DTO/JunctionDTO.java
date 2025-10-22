package org.canara.CampusWay.DTO;

public class JunctionDTO {

    private Long id;
    private String name;

    // Default Constructor
    public JunctionDTO() {}

    // Parameterized Constructor
    public JunctionDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JunctionDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
          '}';
}
}