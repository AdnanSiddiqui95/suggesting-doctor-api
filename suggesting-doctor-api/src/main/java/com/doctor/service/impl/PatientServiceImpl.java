package com.doctor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.entity.Doctor;
import com.doctor.entity.Patient;
import com.doctor.exception.PatientNotFoundException;
import com.doctor.repository.DoctorRepository;
import com.doctor.repository.PatientRepository;
import com.doctor.service.PatientService;
import com.doctor.utility.Symptom;

import jakarta.validation.Valid;

@Service
public class PatientServiceImpl implements PatientService 
{
	@Autowired private PatientRepository patientRepository;
	@Autowired private DoctorRepository doctorRepository;
	
	public void savePatient(@Valid Patient patient) 
	{
		patientRepository.save(patient);
	}

	public List<Doctor> findDoctorListByPatientSymptom(int pid) 
	{
		Patient patient=patientRepository.findById(pid).orElse(null);
		if(patient==null)
		{
			throw new PatientNotFoundException("Patient with id "+pid+" does not exist");
		}
		String city=patient.getCity();
		if(!(city.equals("Delhi")|| city.equals("Noida")||city.equals("Faridabad")))
		{
			throw new RuntimeException("We are still waiting to expand to your location");
		}
		String symptom=patient.getSymptom();
		String speciality=Symptom.map.get(symptom);
		List<Doctor> doctorList=doctorRepository.getDoctorListByCityAndSpeciality(city,speciality);
		if(doctorList.isEmpty())
		{
			throw new RuntimeException("There isn’t any doctor present at your location for your symptom");
		}
		return doctorList;
	}
}
