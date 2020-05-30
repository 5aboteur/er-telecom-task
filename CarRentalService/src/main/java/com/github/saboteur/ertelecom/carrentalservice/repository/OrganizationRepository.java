package com.github.saboteur.ertelecom.carrentalservice.repository;

import com.github.saboteur.ertelecom.carrentalservice.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> { }
