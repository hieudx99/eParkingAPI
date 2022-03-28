package com.example.eparking.repository;

import com.example.eparking.model.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE ParkingSlot p SET p.status = 'U' WHERE p.id = ?1")
    Integer updateStatusDisable(int parkingSlotID);

    @Modifying
    @Transactional
    @Query("UPDATE ParkingSlot p SET p.status = 'O' WHERE p.id = ?1")
    Integer updateStatusEnable(int parkingSlotID);
}
