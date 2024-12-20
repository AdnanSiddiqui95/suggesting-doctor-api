package com.doctor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.entity.Doctor;
import com.doctor.repository.DoctorRepository;
import com.doctor.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService 
{
	@Autowired private DoctorRepository doctorRepository;

	public void saveDoctor(Doctor doctor) 
	{
		doctorRepository.save(doctor);
	}
}
