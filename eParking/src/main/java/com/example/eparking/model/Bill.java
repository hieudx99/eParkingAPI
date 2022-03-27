package com.example.eparking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String createDate;
    private String startTime;
    private String endTime;
    private double total;
    private String paymentStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_methodid", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private PaymentMethod paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parking_slotid")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private ParkingSlot parkingSlot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carid")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private User user;
}
