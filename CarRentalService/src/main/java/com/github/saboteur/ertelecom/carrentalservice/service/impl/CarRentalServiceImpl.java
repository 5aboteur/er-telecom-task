package com.github.saboteur.ertelecom.carrentalservice.service.impl;

import com.github.saboteur.ertelecom.carrentalservice.dto.OrganizationDto;
import com.github.saboteur.ertelecom.carrentalservice.dto.OrganizationShortDto;
import com.github.saboteur.ertelecom.carrentalservice.dto.RentalInfoDto;
import com.github.saboteur.ertelecom.carrentalservice.mapper.domain.OrganizationMapper;
import com.github.saboteur.ertelecom.carrentalservice.mapper.domain.RentalInfoMapper;
import com.github.saboteur.ertelecom.carrentalservice.model.Branch;
import com.github.saboteur.ertelecom.carrentalservice.model.Car;
import com.github.saboteur.ertelecom.carrentalservice.model.Organization;
import com.github.saboteur.ertelecom.carrentalservice.model.RentalInfo;
import com.github.saboteur.ertelecom.carrentalservice.repository.BranchRepository;
import com.github.saboteur.ertelecom.carrentalservice.repository.CarRepository;
import com.github.saboteur.ertelecom.carrentalservice.repository.OrganizationRepository;
import com.github.saboteur.ertelecom.carrentalservice.service.CarRentalService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CarRentalServiceImpl implements CarRentalService {

    final static Logger logger = Logger.getLogger(CarRentalServiceImpl.class);

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private RentalInfoMapper rentalInfoMapper;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Transactional
    @Override
    public List<OrganizationShortDto> getOrganizations(int pageIndex, int pageSize) {
        try {
            return organizationRepository
                .findAll(PageRequest.of(pageIndex, pageSize))
                .map(organizationMapper::convertToShortDto)
                .toList();
        } catch (IllegalArgumentException e) {
            logger.error("Error getting organizations: " + e.getLocalizedMessage());
            return null;
        }
    }

    @Transactional
    @Override
    public Long createOrganization(OrganizationDto organizationDto) {
        Optional<Organization> organization = organizationRepository.findByInn(organizationDto.getInn());

        if (organization.isPresent()) {
            logger.error("Error creating organization: an organization with INN = "
                + organizationDto.getInn()
                + " already exists in the database");
            return -1L;
        }

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

    @Transactional
    @Override
    public Boolean updateCarRentalHistory(String carNumber, RentalInfoDto rentalInfoDto) {
        Optional<Car> car = carRepository.findByNumber(carNumber);

        if (!car.isPresent()) {
            logger.error("Error updating car rental history: a car with number = "
                + carNumber
                + " doesn't exist in the database");
            return false;
        }

        Optional<Branch> branch = branchRepository.findByCode(rentalInfoDto.getBranchCode());

        if (!branch.isPresent()) {
            logger.error("Error updating car rental history: a branch with number = "
                + rentalInfoDto.getBranchCode()
                + " doesn't exist in the database");
            return false;
        }

        if (rentalInfoDto.getDateStart().compareTo(rentalInfoDto.getDateEnd()) > 0) {
            logger.error("Error updating car rental history: a start time ("
                + rentalInfoDto.getDateStart()
                + ") shouldn't precede an end time ("
                + rentalInfoDto.getDateEnd()
                + ") of rental");
            return false;
        }

        Long carId = car.get().getId();

        try {
            Set<RentalInfo> updatedRentalHistory = car
                .get()
                .getRentalHistory();

            updatedRentalHistory.add(rentalInfoMapper.convertToEntity(rentalInfoDto));
            Car updatedCar = car.get();
            updatedCar.setRentalHistory(updatedRentalHistory);
            Long updatedId = carRepository.save(updatedCar).getId();

            if (updatedId.equals(carId)) {
                return true;
            } else {
                logger.error("Error updating car rental history: updated ID ("
                    + updatedId.toString()
                    + ") != car ID ("
                    + carId.toString()
                    + ")");
                return false;
            }
        } catch (IllegalArgumentException e) {
            logger.error("Error updating car rental history: " + e.getLocalizedMessage());
            return false;
        }
    }

}
