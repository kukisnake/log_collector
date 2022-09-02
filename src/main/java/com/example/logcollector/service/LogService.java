package com.example.logcollector.service;

import com.example.logcollector.dto.LogDto;
import com.example.logcollector.entity.Log;
import com.example.logcollector.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogService {

    @Autowired
    LogRepository logRepository;

    public Long createLog(LogDto logDto) {
        Log log = new Log();
        log.setContent(logDto.getContent());
        log.setFormat(logDto.getFormat());
        log.setLogLevel(logDto.getLogLevel());
        log.setInvokingClass((logDto.getInvokingClass()));
        log.setEventDate(LocalDateTime.now());
        logRepository.save(log);
        return log.getId();
    }
}
