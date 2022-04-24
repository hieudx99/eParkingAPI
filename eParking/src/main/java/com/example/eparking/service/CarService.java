package com.example.eparking.service;

import com.example.eparking.model.Car;

public interface CarService {
    Car getCarById(int id);
    Car addCar(Car car, int userid);
    Car updateCar(Car car, int userid);
}
