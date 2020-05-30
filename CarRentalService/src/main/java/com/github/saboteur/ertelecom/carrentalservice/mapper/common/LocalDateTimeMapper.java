package com.github.saboteur.ertelecom.carrentalservice.mapper.common;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Component
public class LocalDateTimeMapper {

    final static Logger logger = Logger.getLogger(LocalDateTimeMapper.class);

    private final DateTimeFormatter dateTimeFormatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public String convertToString(LocalDateTime ldt) {
        return ldt.format(dateTimeFormatter);
    }

    public LocalDateTime convertToLocalDateTime(String str) throws IllegalArgumentException {
        try {
            return LocalDateTime.parse(str, dateTimeFormatter);
        } catch (DateTimeParseException ex) {
            logger.error("Couldn't parse date (" + str + ") to 'yyyy-MM-dd HH:mm' format");
            throw new IllegalArgumentException("Wrong date provided");
        }
    }

}
