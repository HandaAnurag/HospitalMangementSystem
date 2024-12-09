package com.cg.controller;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.DoctorDTO;
import com.cg.exception.InvalidProductException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Doctor;
import com.cg.service.IDoctorService;
import jakarta.validation.Valid;

@RequestMapping("/api")
@RestController
public class DoctorController {
	
	@Autowired
	IDoctorService doctorService;
    
	//LOGGER
	//public static final Logger logger = LoggerFactory.getLogger(DoctorController.class);
	// Logger logger = LoggerFactory.getLogger(DoctorController.class);
	 
	Logger log=org.slf4j.LoggerFactory.getLogger(DoctorController.class);
	@GetMapping(path = "/doctors", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Doctor> getAllDoctors(){
		log.info("Here is your doctors: ");
		return doctorService.findAllDoctors();
		
	}
	
	@GetMapping(path="/doctors/{id}")
	 public DoctorDTO getDoctorById(@PathVariable int id) throws ResourceNotFoundException {
       return doctorService.findDoctorById(id)
                           .map(DoctorDTO::fromEntity)  
                           .orElseThrow(() -> new ResourceNotFoundException("Doctor not found for this id :: " + id));
   }
	
	@GetMapping("/doctor/{id}")
	Optional<Doctor>findByDoctorId(@PathVariable int id)
	{	
		return doctorService.findDoctorById(id);	
	}
	
	@PostMapping("/doctors")
	public Doctor createDoctor(	@RequestBody Doctor d) {
		return doctorService.createDoctor(d);
	}
	
	
	@DeleteMapping("/doctors/{id}")
	public void deleteDoctor(@PathVariable int id)
	{
	    doctorService.deleteDoctor(id);
	}
	

	
	@PutMapping("/update/{id}")
	public Doctor updateDoctor(@PathVariable int id, @RequestBody Doctor d) 
	{
	    return doctorService.updateDoctor(id, d);
	}

	@GetMapping("/doctors/ByQualification/{qualification}")
	public Doctor findDoctorByQualification(@Valid @PathVariable String qualification) {
		return doctorService.findDoctorByQualification(qualification);
	}
	
	
}
