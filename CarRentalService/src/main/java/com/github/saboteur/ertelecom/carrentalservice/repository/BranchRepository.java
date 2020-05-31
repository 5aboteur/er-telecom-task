package com.github.saboteur.ertelecom.carrentalservice.repository;

import com.github.saboteur.ertelecom.carrentalservice.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    Optional<Branch> findByCode(String code);
}
