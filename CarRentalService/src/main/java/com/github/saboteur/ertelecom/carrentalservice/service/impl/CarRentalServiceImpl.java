package com.github.saboteur.ertelecom.carrentalservice.service.impl;

import com.github.saboteur.ertelecom.carrentalservice.dto.OrganizationDto;
import com.github.saboteur.ertelecom.carrentalservice.mapper.domain.OrganizationMapper;
import com.github.saboteur.ertelecom.carrentalservice.model.Organization;
import com.github.saboteur.ertelecom.carrentalservice.repository.OrganizationRepository;
import com.github.saboteur.ertelecom.carrentalservice.service.CarRentalService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CarRentalServiceImpl implements CarRentalService {

    final static Logger logger = Logger.getLogger(CarRentalServiceImpl.class);

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Transactional
    @Override
    public List<OrganizationDto> getOrganizations(int pageIndex, int pageSize) {
        return organizationRepository
            .findAll(PageRequest.of(pageIndex, pageSize))
            .map(organizationMapper::convertToDto)
            .toList();
    }

    @Transactional
    @Override
    public Long createOrganization(OrganizationDto organizationDto) {
        try {
            return organizationRepository
                .save(organizationMapper.convertToEntity(organizationDto))
                .getId();
        } catch (IllegalArgumentException e) {
            logger.error("Error creating organization: " + e.getLocalizedMessage());
            return -1L;
        }
    }

    @Transactional
    @Override
    public OrganizationDto getOrganization(Long organizationId) {
        return organizationRepository
            .findById(organizationId)
            .map(organizationMapper::convertToDto)
            .orElse(null);
    }

    @Transactional
    @Override
    public Boolean updateOrganization(Long organizationId, OrganizationDto organizationDto) {
        Optional<Organization> organization = organizationRepository.findById(organizationId);

        if (!organization.isPresent()) {
            logger.error("Error updating organization: an organization with ID = "
                + organizationId.toString()
                + " doesn't exist in the database");
            return false;
        }

        try {
            Organization updatedOrganization = organizationMapper.convertToEntity(organizationDto);
            updatedOrganization.setId(organizationId);
            Long updatedId = organizationRepository.save(updatedOrganization).getId();

            if (updatedId.equals(organizationId)) {
                return true;
            } else {
                logger.error("Error updating organization: updated ID ("
                    + updatedId.toString()
                    + ") != provided ID ("
                    + organizationId.toString()
                    + ")");
                return false;
            }
        } catch (IllegalArgumentException e) {
            logger.error("Error updating organization: " + e.getLocalizedMessage());
            return false;
        }
    }

    @Transactional
    @Override
    public Boolean deleteOrganization(Long organizationId) {
        Optional<Organization> organization = organizationRepository.findById(organizationId);

        if (!organization.isPresent()) {
            logger.error("Error deleting organization: an organization with ID = "
                + organizationId.toString()
                + " doesn't exist in the database");
            return false;
        }

        organizationRepository.deleteById(organizationId);

        return true;
    }

}
