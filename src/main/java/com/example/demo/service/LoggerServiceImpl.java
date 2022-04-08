package com.example.demo.service;

import com.example.demo.domain.Logger;
import com.example.demo.repo.LoggerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements LoggerService{

    @Autowired
    LoggerRepo loggerRepo;

    @Override
    public void add(Logger log) {
        loggerRepo.save(log);
    }
}
