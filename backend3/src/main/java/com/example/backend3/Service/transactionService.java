package com.example.backend3.Service;

import com.example.backend3.Entity.transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;


public interface transactionService {



    List<transaction> getAllEmployees();
    transaction getEmployeeById(long id);
    Page<transaction> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
