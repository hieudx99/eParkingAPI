package com.example.eparking.controller;

import com.example.eparking.model.Car;
import com.example.eparking.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController{

    @Autowired
    private CarService carService;

    @GetMapping("/get-by-id")
    public Car getCarById(@RequestParam("id") int id) {
        return carService.getCarById(id);
    }

    @PostMapping("/add-car")
    public Car addCar(@RequestBody Car car, @RequestParam("userid") int userid) {
        return carService.addCar(car, userid);
    }

    @PostMapping("/update-car")
    public Car updateCar(@RequestBody Car car, @RequestParam("userid") int userid) {
        return carService.updateCar(car, userid);
    }
}
