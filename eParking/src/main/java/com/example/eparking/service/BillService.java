package com.example.eparking.service;

import com.example.eparking.model.Bill;

import java.util.List;

public interface BillService {

    Bill createBill(Bill bill);
    List<Bill> getUserParkingHistory(int userid, String startDate, String endDate);
}
