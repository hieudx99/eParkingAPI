package com.example.eparking.service.imp;

import com.example.eparking.model.Bill;
import com.example.eparking.repository.BillRepository;
import com.example.eparking.service.BillService;
import com.example.eparking.service.ParkingSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Timer;

@Service
public class BillServiceImp implements BillService {

    @Autowired
    BillRepository billRepository;
    @Autowired
    ParkingSlotService parkingSlotService;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public Bill createBill(Bill bill) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String createdAt = simpleDateFormat.format(now);
        bill.setCreateDate(createdAt);
        Bill billResponse = billRepository.saveAndFlush(bill);
        if (billResponse != null) {
            //sau khi tao hoa don update trang thai parking slot disable
            parkingSlotService.updateStatusDisable(bill.getParkingSlot().getId());

            //tao task enable parking slot sau khi bill het thoi gian
            Date start = simpleDateFormat.parse(billResponse.getCreateDate());
            Date end = simpleDateFormat.parse(billResponse.getEndTime());
            Duration diff = Duration.between(start.toInstant(), end.toInstant());
            TaskBillTimer task = new TaskBillTimer(
                    billResponse.getParkingSlot().getId(),
                    parkingSlotService);
            Timer timer = new Timer();
            timer.schedule(task, diff.getSeconds()*1000);
            return billResponse;
        }

        return null;
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

    @Override
    public Bill getBillByParkingSlotId(int parkingSlotId) {
        return billRepository.findFirstByParkingSlot_IdOrderByCreateDateDesc(parkingSlotId);
    }
}


