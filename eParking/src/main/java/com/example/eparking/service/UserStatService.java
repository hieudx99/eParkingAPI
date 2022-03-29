package com.example.eparking.service;

import com.example.eparking.model.UserStat;

import java.util.List;

public interface UserStatService {
    List<UserStat> getListUserStat(String startDate, String endDate);
}
