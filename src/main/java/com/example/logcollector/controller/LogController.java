package com.example.logcollector.controller;

import com.example.logcollector.dto.LogDto;
import com.example.logcollector.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class LogController {
    @Autowired
    LogService logService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/log")
    public @ResponseBody
    Long createLog(@RequestBody LogDto logDto) {
        return logService.createLog(logDto);
    }
}
