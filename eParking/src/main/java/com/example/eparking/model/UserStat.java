package com.example.eparking.model;

import java.util.List;

public class UserStat extends User{
    private int rentTimes;
    private double rentTotal;

    public UserStat(int id, String fullname, String email, String identityCard, String telephone, String address, String username, String password, List<Car> listCar, Role role, int rentTimes, double rentTotal) {
        super(id, fullname, email, identityCard, telephone, address, username, password, listCar, role);
        this.rentTimes = rentTimes;
        this.rentTotal = rentTotal;
    }

    public UserStat(int rentTimes, double rentTotal) {
        this.rentTimes = rentTimes;
        this.rentTotal = rentTotal;
    }

    public int getRentTimes() {
        return rentTimes;
    }

    public void setRentTimes(int rentTimes) {
        this.rentTimes = rentTimes;
    }

    public double getRentTotal() {
        return rentTotal;
    }

    public void setRentTotal(double rentTotal) {
        this.rentTotal = rentTotal;
    }
}
