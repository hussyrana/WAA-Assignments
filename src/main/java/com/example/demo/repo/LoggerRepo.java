package com.example.demo.repo;

import com.example.demo.domain.Logger;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoggerRepo extends CrudRepository<Logger, Integer> {
    List<Logger> findAll();
}
