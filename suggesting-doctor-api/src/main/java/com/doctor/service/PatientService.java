package com.doctor.service;

import java.util.List;

import com.doctor.entity.Doctor;
import com.doctor.entity.Patient;

import jakarta.validation.Valid;

public interface PatientService 
{
	void savePatient(@Valid Patient patient);
	List<Doctor> findDoctorListByPatientSymptom(int pid);
}
