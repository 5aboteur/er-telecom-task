package com.github.saboteur.ertelecom.carrentalservice.mapper.common;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class LocalDateTimeMapper {

    private final DateTimeFormatter dateTimeFormatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public String convertToString(LocalDateTime ldt) {
        return ldt.format(dateTimeFormatter);
    }

    public LocalDateTime convertToLocalDateTime(String str) {
        return LocalDateTime.parse(str, dateTimeFormatter);
    }

}
