package com.example.eparking.service.imp;

import com.example.eparking.model.Role;
import com.example.eparking.model.User;
import com.example.eparking.repository.UserRepository;
import com.example.eparking.security.JwtConfig;
import com.example.eparking.service.UserService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private JwtConfig jwtConfig;


    @Override
    public ResponseEntity<User> findByUsernameAndPassword(String username, String password) {
        Optional<User> userOpt = userRepository.findUserByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                String token = generateToken(user);
                return ResponseEntity.ok().header(jwtConfig.getHeader(), token).body(user);
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

    @Override
    public ResponseEntity<User> google(String googleAccessToken) {
        String fullname = "";
        String email = "";
        String token = "";
        User user = null;
        googleAccessToken = googleAccessToken.substring(1, googleAccessToken.length()-1);
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                .setAudience(Collections.singletonList("79214693346-ndqme1517s4falshkdhhd86mm24d8d9g.apps.googleusercontent.com"))
                .build();

        try {
            GoogleIdToken idToken = verifier.verify(googleAccessToken);
            if (idToken != null) {
                GoogleIdToken.Payload payload = idToken.getPayload();
                email = payload.getEmail();
                fullname = (String) payload.get("name");
            }
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Optional<User> userOpt = userRepository.findUserByEmail(email);
        if (userOpt.isPresent()) {
            user = userOpt.get();
            token = generateToken(user);
        }
        else {
            Role role = new Role(1, "");
            User userTemp = User.builder()
                    .username(email)
                    .email(email)
                    .password(passwordEncoder.encode("123456"))
                    .fullname(fullname)
                    .role(role)
                    .build();
            user = userRepository.saveAndFlush(userTemp);
            token = generateToken(user);
        }

//        String url = "https://oauth2.googleapis.com/tokeninfo?id_token=";
//        url += googleAccessToken;
//        GoogleUser googleUser = restTemplate.getForObject(url, GoogleUser.class);
//        String email = googleUser.getEmail();
//        System.out.println(googleUser);
        return ResponseEntity.ok().header(jwtConfig.getHeader(),token).body(user);
    }


    private String generateToken(User user) {
        Long now = System.currentTimeMillis();
        String token = Jwts.builder().setSubject(user.getEmail())
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + jwtConfig.getExpiration()*1000))
                .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret().getBytes())
                .compact();
        return jwtConfig.getPrefix() + token;
    }
}
