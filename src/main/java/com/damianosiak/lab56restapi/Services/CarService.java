package com.damianosiak.lab56restapi.Services;

import com.damianosiak.lab56restapi.Model.Car;
import com.damianosiak.lab56restapi.Repositories.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional
    public Long addCar(Car car){
        return carRepository.save(car).getCarId();
    }

    @Transactional
    public void deleteCar(Long carId){
        Optional<Car> car = carRepository.findById(carId);
        if(car.isPresent()){
            carRepository.delete(car.get());
        }
    }

    @Transactional
    public Optional<Car> get(Long carId){
        return carRepository.findById(carId);
    }

    @Transactional
    public List<Car> get(){
        return carRepository.findAll();
    }

    @Transactional
    public void update(Long carId, Car carBody){
        Optional<Car> car = carRepository.findById(carId);
        if(car.isPresent()){
            car.get().setCarModel(carBody.getCarModel());
            car.get().setCarYear(carBody.getCarYear());
            car.get().setCarType(carBody.getCarType());
            carRepository.save(car.get());
        }
    }
}
