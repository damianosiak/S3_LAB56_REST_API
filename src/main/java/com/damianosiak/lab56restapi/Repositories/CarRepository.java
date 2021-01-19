package com.damianosiak.lab56restapi.Repositories;

import com.damianosiak.lab56restapi.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
