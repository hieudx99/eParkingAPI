package com.example.eparking.service.imp;

import com.example.eparking.service.ParkingSlotService;

import java.util.TimerTask;

class TaskBillTimer extends TimerTask {

    private int parkingSlotId;
    private ParkingSlotService parkingSlotService;

    public TaskBillTimer(int parkingSlotId, ParkingSlotService parkingSlotService) {
        this.parkingSlotId = parkingSlotId;
        this.parkingSlotService = parkingSlotService;
    }


    @Override
    public void run() {
        this.parkingSlotService.updateStatusEnable(this.parkingSlotId);
    }
}