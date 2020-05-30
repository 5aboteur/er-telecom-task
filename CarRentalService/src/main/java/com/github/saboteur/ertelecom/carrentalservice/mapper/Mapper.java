package com.github.saboteur.ertelecom.carrentalservice.mapper;

public interface Mapper<ENTITY, DTO> {
    DTO convertToDto(ENTITY entity);
    ENTITY convertToEntity(DTO dto);
}
