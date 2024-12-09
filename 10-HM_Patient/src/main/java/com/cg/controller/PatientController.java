package com.cg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.PatientDTO;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Patient;
import com.cg.service.IPatientService;

import jakarta.validation.Valid;

@RequestMapping("/test")
@RestController
public class PatientController {
	
	@Autowired
	IPatientService patientService;
    
	
	//authentication for patient user
	
	@GetMapping(path = "/auth", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Patient> getPatients(@ RequestHeader("Authorization") String token){
		System.out.println("Authorization" + token);
		if (patientService.hasPermission(token))
			return patientService.findAllPatients();
		else
			return null;
		
	}
	
	
	@GetMapping(path = "/patients", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Patient> getPatients(){
		return patientService.findAllPatients();		
	}
	
	@GetMapping(path="/patient/{id}")
	 public PatientDTO getPatientById(@PathVariable int id) throws ResourceNotFoundException {
      return patientService.findPatientById(id)
                          .map(PatientDTO::fromEntity)  
                          .orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + id));
  }
	
	@GetMapping("/patients/{id}")
	Optional<Patient>findByPatientId(@PathVariable int id)
	{
		return patientService.findPatientById(id);

	}
	
	@PostMapping("/patients")
	public Patient createPatient(@Valid @RequestBody Patient p) {
		return patientService.createPatient(p);
	}
	
//	
	@DeleteMapping("/patients/{id}")
	public void deletePatient(@PathVariable int id)
	{
	    Optional<Patient> product = patientService.findPatientById(id);
	    patientService.deletePatient(id);
	}
	

	
	@PutMapping("/patients/{id}")
	public Patient updatePatient(@PathVariable int id, @RequestBody Patient p) 
	{
	    return patientService.updatePatient(id, p);
	}
	
	
}
