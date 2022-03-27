package com.example.eparking.controller;

import com.example.eparking.model.ParkingSlot;
import com.example.eparking.service.ParkingSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parking-slot")
public class ParkingSlotController {

    @Autowired
    ParkingSlotService parkingSlotService;

    @GetMapping("/find-all")
    public List<ParkingSlot> findAll() {
        return parkingSlotService.findAll();
    }

}
