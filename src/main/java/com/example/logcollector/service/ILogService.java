package com.example.logcollector.service;

import com.example.logcollector.dto.LogDto;
import com.example.logcollector.entity.Log;

import java.util.List;

public interface ILogService {

    Long createLog(LogDto logDto);

    List<Log> getPaginatedLogs(int page, int size);

    List<Log> getAllLogs();

    void updateLog(Log log);

    Log getLogById(Long id);

    List<Log> getSortedLogs(String sortedField);
}
