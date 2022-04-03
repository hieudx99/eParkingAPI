package com.example.eparking.controller;


import com.example.eparking.model.UserStat;
import com.example.eparking.model.dto.StartEndDateDTO;
import com.example.eparking.service.UserStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-stat")
public class UserStatController {

    @Autowired
    private UserStatService userStatService;

    @PostMapping("")
    public List<UserStat> getListUserStat(@RequestBody StartEndDateDTO dates) {
        return userStatService.getListUserStat(dates.getStartDate(), dates.getEndDate());
    }


}
