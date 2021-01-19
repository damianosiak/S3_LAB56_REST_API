package com.damianosiak.lab56restapi.Services;

import com.damianosiak.lab56restapi.Model.Car;
import com.damianosiak.lab56restapi.Model.Manufacturer;
import com.damianosiak.lab56restapi.Repositories.CarRepository;
import com.damianosiak.lab56restapi.Repositories.ManufacturerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;
    private final CarRepository carRepository;

    public ManufacturerService(ManufacturerRepository manufacturerRepository, CarRepository carRepository) {
        this.manufacturerRepository = manufacturerRepository;
        this.carRepository = carRepository;
    }

    @Transactional
    public Long addManufacturer(Manufacturer manufacturer){
        return manufacturerRepository.save(manufacturer).getManufacturerId();
    }

    @Transactional
    public void deleteManufacturer(Long manufacturerId){
        Optional<Manufacturer> manufacturer = manufacturerRepository.findById(manufacturerId);
        if(manufacturer.isPresent()){
            manufacturerRepository.delete(manufacturer.get());
        }
    }

    @Transactional
    public Optional<Manufacturer> get(Long manufacturerId){
        return manufacturerRepository.findById(manufacturerId);
    }

    @Transactional
    public List<Manufacturer> get(){
        return manufacturerRepository.findAll();
    }

    @Transactional
    public void update(Long manufacturerId, Manufacturer manufacturerBody){
        Optional<Manufacturer> manufacturer = manufacturerRepository.findById(manufacturerId);
        if(manufacturer.isPresent()){
            manufacturer.get().setManufacturerName(manufacturerBody.getManufacturerName());
            manufacturer.get().setManufacturerCountry(manufacturerBody.getManufacturerCountry());
            manufacturerRepository.save(manufacturer.get());
        }
    }

    @Transactional
    public void addManufacturerCar(Long manufacturerId, Long carId){
        Optional<Manufacturer> manufacturer = manufacturerRepository.findById(manufacturerId);
        if(manufacturer.isPresent()){
            manufacturer.get().getManufacturerCars().add(carRepository.findById(carId).get());
        }
    }

    @Transactional
    public Set<Car> getManufacturerCar(Long manufacturerId){
        return manufacturerRepository.findById(manufacturerId).get().getManufacturerCars();
    }
}
