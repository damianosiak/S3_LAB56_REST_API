package com.damianosiak.lab56restapi.Controlers;

import com.damianosiak.lab56restapi.Model.Car;
import com.damianosiak.lab56restapi.Services.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {
    CarService carService;
    CarController(CarService carService){
        this.carService=carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> list(){
        return new ResponseEntity(carService.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> add(@RequestBody Car car){
        return new ResponseEntity(carService.addCar(car),HttpStatus.OK);
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<Void> delete(@PathVariable Long carId){
        carService.deleteCar(carId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{carId}")
    public ResponseEntity<Car> get(@PathVariable Long carId){
        Optional<Car> car = carService.get(carId);
        if(car.isPresent()){
            return new ResponseEntity(car.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/{carId}")
    public ResponseEntity<Car> update(@PathVariable Long carId, @RequestBody Car carBody){
        Optional<Car> car = carService.get(carId);
        if(car.isPresent()){
            carService.update(carId,carBody);
            return new ResponseEntity(car.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
