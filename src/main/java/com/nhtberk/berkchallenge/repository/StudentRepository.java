package com.nhtberk.berkchallenge.repository;

import com.nhtberk.berkchallenge.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
