package com.example.backend3.Repository;

import com.example.backend3.Entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface groupRepository extends JpaRepository<Group,Long> {
    @Override
    List<Group> findAll();
}
