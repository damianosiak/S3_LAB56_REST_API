package com.damianosiak.lab56restapi.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Manufacturer {
    @Id
    @GeneratedValue
    private Long manufacturerId;
    private String manufacturerName;
    private String manufacturerCountry;
    @OneToMany
    private Set<Car> manufacturerCars = new HashSet<>();

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerCountry() {
        return manufacturerCountry;
    }

    public void setManufacturerCountry(String manufacturerCountry) {
        this.manufacturerCountry = manufacturerCountry;
    }

    public Set<Car> getManufacturerCars() {
        return manufacturerCars;
    }

    public void setManufacturerCars(Set<Car> manufacturerCars) {
        this.manufacturerCars = manufacturerCars;
    }

    public Manufacturer() {
    }

//    public Manufacturer(Long manufacturerId, String manufacturerName, String manufacturerCountry) {
//        this.manufacturerId = manufacturerId;
//        this.manufacturerName = manufacturerName;
//        this.manufacturerCountry = manufacturerCountry;
//    }


    public Manufacturer(Long manufacturerId, String manufacturerName, String manufacturerCountry, Set<Car> manufacturerCars) {
        this.manufacturerId = manufacturerId;
        this.manufacturerName = manufacturerName;
        this.manufacturerCountry = manufacturerCountry;
        this.manufacturerCars = manufacturerCars;
    }
}
