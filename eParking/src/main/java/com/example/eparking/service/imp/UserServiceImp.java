package com.example.eparking.service.imp;

import com.example.eparking.model.Role;
import com.example.eparking.model.User;
import com.example.eparking.repository.UserRepository;
import com.example.eparking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public User findByUsernameAndPassword(String username, String password) {
        Optional<User> userOpt = userRepository.findUserByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Transactional
    @Override
    public User register(User user) {
        user.setRole(new Role(1,""));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.saveAndFlush(user);

//        KeyHolder keyHolder = new GeneratedKeyHolder();
//
//        String sql = "INSERT INTO tbl_user(username, password, fullname, identity_card," +
//                "telephone, address, roleid) VALUES(?, ?, ?, ?, ?, ?, ?)";
////        jdbcTemplate.update(sql, user.getUsername(), passwordEncoder.encode(user.getPassword()),
////                user.getFullname(), user.getIdentityCard(), user.getTelephone(), user.getAddress(), 1);
//        jdbcTemplate.update(con -> {
//            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, user.getUsername());
//            ps.setString(2, passwordEncoder.encode(user.getPassword()));
//            ps.setString(3, user.getFullname());
//            ps.setString(4, user.getIdentityCard());
//            ps.setString(5, user.getTelephone());
//            ps.setString(6, user.getAddress());
//            ps.setInt(7,1);
//            return ps;
//        }, keyHolder);
//
//        int id = keyHolder.getKey().intValue();
//        if (id > 0) {
//            user.setId(id);
//            return user;
//        }
//        return  null;
    }

    @Override
    public User updateInfo(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> searchUserByName(String kw) {
        return userRepository.findUserByKw(kw);
    }
}
