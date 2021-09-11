package com.example.backend3.Repository;

import com.example.backend3.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface userRepository extends JpaRepository< User,Long> {
    @Override
    List<User> findAll();
}
