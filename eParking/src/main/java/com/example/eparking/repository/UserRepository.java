package com.example.eparking.repository;

import com.example.eparking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByUsername(String username);
    @Query("FROM User AS u WHERE u.fullname LIKE %?1% AND u.role.id = 1")
    List<User> findUserByKw(String kw);

}
