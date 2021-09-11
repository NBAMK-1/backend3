package com.example.backend3.Service;

import com.example.backend3.Entity.transaction;
import com.example.backend3.Repository.transactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class transactionServiceImpl implements transactionService {
    @Autowired
    private transactionRepository transRepo;

    @Override
    public List<transaction> getAllEmployees() {
        return transRepo.findAll();
    }

    @Override
    public transaction getEmployeeById(long id) {
        Optional<transaction> optional = transRepo.findById(id);
        transaction employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
    }

    @Override
    public Page<transaction> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.transRepo.findAll(pageable);
    }
}
