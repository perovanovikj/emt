package com.example.lab1b.dto;

import com.example.lab1b.model.Host;
import com.example.lab1b.model.enumerations.Category;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class CreateAccomodationDto {
    private String name;

    private Category category;

    private Long host;

    private Integer numRooms;

    public CreateAccomodationDto() {
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

    public CreateAccomodationDto(String name, Category category, Long host, Integer numRooms) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
    }
}
