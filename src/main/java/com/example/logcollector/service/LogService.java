package com.example.logcollector.service;

import com.example.logcollector.LogFormat;
import com.example.logcollector.dto.LogDto;
import com.example.logcollector.entity.Log;
import com.example.logcollector.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogService implements ILogService {

    @Autowired
    LogRepository logRepository;

    @Override
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

    @Override
    public List<Log> getPaginatedLogs(int page, int size) {

        PageRequest pageReq = PageRequest.of(page, size);

        Page<Log> logs = logRepository.findAll(pageReq);
        return logs.getContent();
    }

    @Override
    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

    @Override
    public void updateLog(Log log) {
        logRepository.save(log);
    }

    @Override
    public Log getLogById(Long id) {
        return logRepository.getOne(id);
    }

    @Override
    public List<Log> getSortedLogs(String sortedField) {
        return logRepository.findAll(Sort.by(Sort.Direction.ASC, sortedField));
    }
}
