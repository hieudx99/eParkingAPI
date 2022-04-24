package com.example.eparking.service.imp;

import com.example.eparking.model.Car;
import com.example.eparking.model.User;
import com.example.eparking.repository.CarRepository;
import com.example.eparking.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImp implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public Car getCarById(int id) {
        return carRepository.getCarById(id);
    }

    @Override
    public Car addCar(Car car, int userid) {
        User user = new User();
        user.setId(userid);
        car.setUser(user);
        return carRepository.saveAndFlush(car);
    }

    @Override
    public Car updateCar(Car car, int userid) {
        User user = new User();
        user.setId(userid);
        car.setUser(user);
        return carRepository.save(car);
    }
}
