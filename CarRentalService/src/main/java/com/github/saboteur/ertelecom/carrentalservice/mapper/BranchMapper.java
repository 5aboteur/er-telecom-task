package com.github.saboteur.ertelecom.carrentalservice.mapper;

import com.github.saboteur.ertelecom.carrentalservice.dto.BranchDto;
import com.github.saboteur.ertelecom.carrentalservice.model.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BranchMapper implements Mapper<Branch, BranchDto> {

    @Autowired
    private LocationMapper locationMapper;

    @Override
    public BranchDto convertToDto(Branch entity) {
        return new BranchDto(
            entity.getPhone(),
            locationMapper.convertToDto(entity.getLocation())
        );
    }

    @Override
    public Branch convertToEntity(BranchDto dto) {
        return new Branch(
            dto.getPhone(),
            locationMapper.convertToEntity(dto.getLocation())
        );
    }

}
