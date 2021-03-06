package com.github.saboteur.ertelecom.carrentalservice.repository;

import com.github.saboteur.ertelecom.carrentalservice.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Optional<Organization> findByInn(String inn);
}
