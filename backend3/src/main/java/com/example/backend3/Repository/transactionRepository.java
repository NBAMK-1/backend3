package com.example.backend3.Repository;

import com.example.backend3.Entity.transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface transactionRepository extends JpaRepository<transaction,Long > {
@Override
List<transaction> findAll();
}
