package com.example.eparking.service.imp;

import com.example.eparking.model.ParkingSlot;
import com.example.eparking.repository.ParkingSlotRepository;
import com.example.eparking.service.ParkingSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSlotServiceImp implements ParkingSlotService {

    @Autowired
    ParkingSlotRepository parkingSlotRepository;

    @Override
    public List<ParkingSlot> findAll() {
        return parkingSlotRepository.findAll(Sort.by("name").ascending());
    }
}
