package com.example.eparking.repository;

import com.example.eparking.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

    @Query("FROM Bill as b WHERE b.user.id = ?1 AND b.createDate BETWEEN ?2 AND ?3 ORDER BY b.createDate DESC")
    List<Bill> getUserParkingHistory(int userid, String startDate, String endDate);

//    @Query("FROM Bill as b WHERE b.parkingSlot.id = ?1 ORDER BY b.createDate DESC")
//    Bill getBillByParkingSlotId(int parkingSlotId);

    Bill findFirstByParkingSlot_IdOrderByCreateDateDesc(int parkingSlotId);


}
