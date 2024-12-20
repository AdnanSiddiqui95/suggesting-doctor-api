package com.doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.entity.Doctor;
import com.doctor.service.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("doctor")
public class DcotorController 
{
	@Autowired private DoctorService doctorService;
	
	@PostMapping("add")
	public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody Doctor doctor)
	{
		doctorService.saveDoctor(doctor);
		return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
	}
}
