package com.example.logcollector.dto;

import com.example.logcollector.LogFormat;
import com.example.logcollector.LogLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class LogDto {

    private String content;
    private LogFormat format;
    private LocalDateTime eventDate;
    private LogLevel logLevel;
    private String invokingClass;



    public LogDto() {

    }
}
