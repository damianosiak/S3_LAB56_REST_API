package com.damianosiak.lab56restapi.Controlers;

import com.damianosiak.lab56restapi.Model.Car;
import com.damianosiak.lab56restapi.Model.Manufacturer;
import com.damianosiak.lab56restapi.Services.CarService;
import com.damianosiak.lab56restapi.Services.ManufacturerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {
    ManufacturerService manufacturerService;
    CarService carService;
    ManufacturerController(ManufacturerService manufacturerService, CarService carService){
        this.manufacturerService=manufacturerService;
        this.carService=carService;
    }

    @GetMapping
    public ResponseEntity<List<Manufacturer>> list(){
        return new ResponseEntity(manufacturerService.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> add(@RequestBody Manufacturer manufacturer){
        return new ResponseEntity(manufacturerService.addManufacturer(manufacturer),HttpStatus.OK);
    }

    @DeleteMapping("/{manufacturerId}")
    public ResponseEntity<Void> delete(@PathVariable Long manufacturerId){
        manufacturerService.deleteManufacturer(manufacturerId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{manufacturerId}")
    public ResponseEntity<Manufacturer> get(@PathVariable Long manufacturerId){
        Optional<Manufacturer> manufacturer = manufacturerService.get(manufacturerId);
        if(manufacturer.isPresent()){
            return new ResponseEntity(manufacturer.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/{manufacturerId}")
    public ResponseEntity<Manufacturer> update(@PathVariable Long manufacturerId, @RequestBody Manufacturer manufacturerBody){
        Optional<Manufacturer> manufacturer = manufacturerService.get(manufacturerId);
        if(manufacturer.isPresent()){
            manufacturerService.update(manufacturerId,manufacturerBody);
            return new ResponseEntity(manufacturer.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/{manufacturerId}/cars/add/{carId}")
    public ResponseEntity<Manufacturer> addManufacturerCar(@PathVariable("manufacturerId") Long manufacturerId, @PathVariable("carId") Long carId){
        Optional<Manufacturer> manufacturer = manufacturerService.get(manufacturerId);
        Optional<Car> car = carService.get(carId);
        if(manufacturer.isPresent() && car.isPresent()){
            manufacturerService.addManufacturerCar(manufacturerId,carId);
            return new ResponseEntity(manufacturer.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{manufacturerId}/cars")
    public ResponseEntity<Set<Car>> manufacturerCar(@PathVariable("manufacturerId") Long manufacturerId){
        return new ResponseEntity(manufacturerService.getManufacturerCar(manufacturerId),HttpStatus.OK);
    }
}
