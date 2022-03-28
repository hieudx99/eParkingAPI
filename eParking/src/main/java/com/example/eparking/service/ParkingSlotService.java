package com.example.eparking.service;


import com.example.eparking.model.ParkingSlot;

import java.util.List;

public interface ParkingSlotService {
    List<ParkingSlot> findAll();
    Integer updateStatusDisable(int parkingSlotId);
    Integer updateStatusEnable(int parkingSlotId);
}
