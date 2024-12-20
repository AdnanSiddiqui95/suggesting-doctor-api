package com.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.doctor.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer> 
{
}
