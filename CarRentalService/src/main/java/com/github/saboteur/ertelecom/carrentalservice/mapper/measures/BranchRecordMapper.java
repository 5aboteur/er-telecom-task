package com.github.saboteur.ertelecom.carrentalservice.mapper.measures;

import com.github.saboteur.ertelecom.carrentalservice.dto.measures.BranchRecordDto;
import com.github.saboteur.ertelecom.carrentalservice.mapper.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class BranchRecordMapper implements Mapper<Map.Entry<String, Long>, BranchRecordDto> {

    @Override
    public BranchRecordDto convertToDto(Map.Entry<String, Long> entity) {
        return new BranchRecordDto(
            entity.getKey(),
            fromLongMinutesToTime(entity.getValue())
        );
    }

    @Override
    public Map.Entry<String, Long> convertToEntity(BranchRecordDto dto) {
        return null;
    }

    private String fromLongMinutesToTime(Long minutes) {
        long hours = TimeUnit.MINUTES.toHours(minutes);
        Long remainingPart = minutes - TimeUnit.HOURS.toMinutes(hours);
        return String.format("%02d:%02d", hours, remainingPart);
    }

}
