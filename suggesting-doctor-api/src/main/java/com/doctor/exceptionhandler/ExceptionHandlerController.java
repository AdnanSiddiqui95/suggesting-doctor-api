package com.doctor.exceptionhandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.doctor.exception.PatientNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerController 
{
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<List<String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		//System.out.println("Handler called");
		BindingResult br=ex.getBindingResult();
		List<ObjectError> errorList=br.getAllErrors();
		//List<String> list=errorList.stream().map(error->error.getDefaultMessage()).toList();
		List<String> list=new ArrayList<>();
		for(ObjectError error:errorList)
		{
			list.add(error.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(list);
	}
	@ExceptionHandler(exception = PatientNotFoundException.class)
	public ResponseEntity<String> handlePatientNotFoundException(PatientNotFoundException ex)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	@ExceptionHandler(exception = RuntimeException.class)
	public ResponseEntity<String> handleRuntimeException(RuntimeException ex)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
}