package com.damianosiak.lab56restapi.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private Long carId;
    private String carModel;
    private Integer carYear;
    private String carType;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Integer getCarYear() {
        return carYear;
    }

    public void setCarYear(Integer carYear) {
        this.carYear = carYear;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Car(Long carId, String carModel, Integer carYear, String carType) {
        this.carId = carId;
        this.carModel = carModel;
        this.carYear = carYear;
        this.carType = carType;
    }

    public Car() {
    }
}
