package com.example.lab1b.dto;

import com.example.lab1b.model.Host;
import com.example.lab1b.model.enumerations.Category;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class AccomodationDto {
    private Long id;

    private String name;

    private Category category;

    private Long host;

    private Integer numRooms;

    public AccomodationDto() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Long getHost() {
        return host;
    }

    public Integer getNumRooms() {
        return numRooms;
    }

    public AccomodationDto(Long id, String name, Category category, Long host, Integer numRooms) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
    }
}
