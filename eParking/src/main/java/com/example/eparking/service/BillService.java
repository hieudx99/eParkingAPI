package com.example.eparking.service;

import com.example.eparking.model.Bill;

import java.text.ParseException;
import java.util.List;

public interface BillService {

    Bill createBill(Bill bill) throws ParseException;
    List<Bill> getUserParkingHistory(int userid, String startDate, String endDate);
    Bill getBillByParkingSlotId(int parkingSlotId);
}
