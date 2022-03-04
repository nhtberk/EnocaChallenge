package com.nhtberk.berkchallenge.repository;

import com.nhtberk.berkchallenge.model.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Long> {
}
