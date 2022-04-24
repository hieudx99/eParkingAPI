package com.example.eparking.controller;

import com.example.eparking.model.Bill;
import com.example.eparking.model.dto.StartEndDateDTO;
import com.example.eparking.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillService billService;

    @PostMapping("/create-bill")
    public Bill createBill(@RequestBody Bill bill) throws ParseException {
        return billService.createBill(bill);
    }

    @PostMapping("/parking-history")
    public List<Bill> getUserParkingHistory(@RequestParam int userid, @RequestBody StartEndDateDTO dates) {
        return billService.getUserParkingHistory(userid, dates.getStartDate(), dates.getEndDate());
    }

    @GetMapping("/get-bill-by-parking-slot")
    public Bill getBillByParkingSlotId(@RequestParam int parkingSlotId) {
        return billService.getBillByParkingSlotId(parkingSlotId);
    }



}
