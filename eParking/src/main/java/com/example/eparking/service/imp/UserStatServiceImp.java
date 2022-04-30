package com.example.eparking.service.imp;

import com.example.eparking.model.User;
import com.example.eparking.model.UserStat;
import com.example.eparking.service.UserService;
import com.example.eparking.service.UserStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserStatServiceImp implements UserStatService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserService userService;

    @Override
    public List<UserStat> getListUserStat(String startDate, String endDate) {
        startDate = startDate + " 00:00:00";
        endDate = endDate + " 23:59:59";
        List<UserStat> listUserStat = new ArrayList<>();
        String sql = "SELECT SUM(b.total) rent_total, COUNT(*) rent_times, b.userid\n" +
                "FROM tbl_bill b LEFT JOIN tbl_user u on u.id = b.userid\n" +
                "WHERE b.create_date >= '" + startDate + "'\n" +
                "AND b.create_date <= '" + endDate + "'\n" +
                "GROUP BY b.userid\n" +
                "ORDER BY rent_total DESC";
        jdbcTemplate.query(sql, new ResultSetExtractor<List<UserStat>>() {
            @Override
            public List<UserStat> extractData(ResultSet rs) throws SQLException, DataAccessException {
                while (rs.next()) {
                    double rentTotal = rs.getDouble("rent_total");
                    int rentTimes = rs.getInt("rent_times");
                    int userId = rs.getInt("userid");
                    Optional<User> userOpt =  userService.findById(userId);
                    if (userOpt.isPresent()) {
                        User user = userOpt.get();
                        UserStat userStat = new UserStat(user.getId(), user.getFullname(), "",
                                user.getIdentityCard(), user.getTelephone(), user.getAddress(),
                                user.getUsername(), user.getPassword(), user.getListCar(), user.getRole(),
                                rentTimes, rentTotal);
                        listUserStat.add(userStat);
                    }
                }
                if (listUserStat.isEmpty()) {
                    return null;
                } else {
                    return listUserStat;
                }
            }
        });
        if (listUserStat.isEmpty() || listUserStat == null) {
            return null;
        } else {
            return listUserStat;
        }
    }
}
