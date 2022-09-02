package com.example.logcollector.entity;

import com.example.logcollector.LogFormat;
import com.example.logcollector.LogLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    @Enumerated(EnumType.STRING)
    private LogFormat format;
    private LocalDateTime eventDate;
    @Enumerated(EnumType.STRING)
    private LogLevel logLevel;
    private String invokingClass;

}
