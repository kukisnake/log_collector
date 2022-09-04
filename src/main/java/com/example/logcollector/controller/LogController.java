package com.example.logcollector.controller;

import com.example.logcollector.dto.APIResponse;
import com.example.logcollector.dto.LogDto;
import com.example.logcollector.entity.Log;
import com.example.logcollector.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LogController {

    @Autowired
    ILogService logService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(path = "/log")
    private @ResponseBody
    Long createLog(@RequestBody LogDto logDto) {
        return logService.createLog(logDto);
    }


    @GetMapping(path = "/logs/paginated/{page}/{size}")
    @ResponseBody
    private APIResponse<List<LogDto>> getPaginatedLogs(
            @PathVariable("page") int page,
            @PathVariable("size") int size) {
        List<Log> paginatedLogs = logService.getPaginatedLogs(page, size);
        List<LogDto> logs = paginatedLogs.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return new APIResponse<>(logs.size(), logs);
    }


    @GetMapping(path = "/logs/{sortedField}")
    @ResponseBody
    private APIResponse<List<LogDto>> getSortedLogs(@PathVariable("sortedField") String sortedField) {
        List<Log> sortedLogs = logService.getSortedLogs(sortedField);
        List<LogDto> logs = sortedLogs.stream().
                map(this::convertToDto)
                .collect(Collectors.toList());
        return new APIResponse<>(logs.size(),logs);
    }


    @GetMapping(path = "/logs")
    @ResponseBody
    private List<LogDto> getAllLogs() {

        List<Log> logs = logService.getAllLogs();
        return logs.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }



    @GetMapping(value = "log/{id}")
    @ResponseBody
    private LogDto getLog(@PathVariable("id") Long id) {
        return convertToDto(logService.getLogById(id));
    }

    private LogDto convertToDto(Log log) {
        LogDto logDto = modelMapper.map(log, LogDto.class);
        return logDto;
    }

}
