package com.doctor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.doctor.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> 
{
	@Query("from Doctor where city=:arg1 and speciality=:arg2")
	List<Doctor> getDoctorListByCityAndSpeciality(@Param("arg1") String city,@Param("arg2") String speciality);
}
