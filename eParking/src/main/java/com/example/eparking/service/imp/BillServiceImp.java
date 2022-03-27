package com.example.eparking.service.imp;

import com.example.eparking.model.Bill;
import com.example.eparking.repository.BillRepository;
import com.example.eparking.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillServiceImp implements BillService {

    @Autowired
    BillRepository billRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Bill createBill(Bill bill) {
        return billRepository.saveAndFlush(bill);
    }

    @Override

    public List<Bill> getUserParkingHistory(int userid, String startDate, String endDate) {
        return billRepository.getUserParkingHistory(userid, startDate, endDate);
//        List<Bill> listBill = new ArrayList<>();
//        String sql = "SELECT * FROM tbl_bill b\n" +
//                "WHERE b.userid = " + userid +"\n" +
//                "AND b.create_date >= '" + startDate + "'\n" +
//                "AND b.create_date <= '" + endDate + "'";
//        listBill = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Bill.class));
//        return listBill;

    }
}
