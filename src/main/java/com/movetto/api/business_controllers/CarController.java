package com.movetto.api.business_controllers;

import com.movetto.api.daos.CarDao;
import com.movetto.api.daos.VehicleDao;
import com.movetto.api.dtos.CarDto;
import com.movetto.api.entities.Bike;
import com.movetto.api.entities.Car;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class CarController extends VehicleController{

    public CarDao carDao;
    public ModelMapper modelMapper;

    public CarController(VehicleDao vehicleDao, CarDao carDao) {
        super(vehicleDao);
        this.carDao = carDao;
        modelMapper = new ModelMapper();
    }

    public ResponseEntity<List<Car>> readCars() {
        return carDao.findAllByIdTrue()
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    public ResponseEntity<Car> readCar(int id){
        return carDao.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    public ResponseEntity<Car> saveCar(CarDto carDto){
        if (carDao.findCarById(carDto.getId()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            Car car = modelMapper.map(carDto,Car.class);
            carDao.save(car);
            return ResponseEntity.ok(car);
        }
    }

    public ResponseEntity<Car> updateCar(CarDto carDto){
        if (carDao.findCarById(carDto.getId()).isPresent()){
            Car car = modelMapper.map(carDto,Car.class);
            carDao.save(car);
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> deleteCar(int id){
        Optional<Car> car = carDao.findCarById(id);
        if (car.isPresent()){
            Car carDeleted = car.get();
            carDeleted.setActive(false);
            carDao.save(carDeleted);
            return ResponseEntity.ok("Car Deleted" + carDeleted.getName());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
