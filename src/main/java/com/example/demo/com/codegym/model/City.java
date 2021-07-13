package com.example.demo.com.codegym.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.stream.events.Comment;

@Entity

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=0,message = "phải là số dương")
    private Long Area;
    @Size(min=0,message = "Phải là số dương")
    private String Comment;
    @Size(min=0,message = "Phải là số dương")
    private Long population;
    @ManyToOne
    private Country country;
    private String name;

    public City(Long id, @Size(min = 0, message = "phải là số dương") Long area, @Size(min = 0, message = "Phải là số dương") String comment, @Size(min = 0, message = "Phải là số dương") Long population, Country country) {
        this.id = id;
        Area = area;
        Comment = comment;
        this.population = population;
        this.country = country;
    }
    public City(){

    }

    public City(Long id, @Size(min = 0, message = "phải là số dương") Long area, @Size(min = 0, message = "Phải là số dương") String comment, @Size(min = 0, message = "Phải là số dương") Long population, Country country, String name) {
        this.id = id;
        Area = area;
        Comment = comment;
        this.population = population;
        this.country = country;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArea() {
        return Area;
    }

    public void setArea(Long area) {
        Area = area;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
