package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.cg.feign.AuthFeign;
import com.cg.model.Patient;
import com.cg.repository.PatientRepository;

@Service
public class PatientService implements IPatientService {

	@Autowired
	PatientRepository prepo;
	@Autowired
	AuthFeign authFeign;
	

	//authentication
	 public boolean hasPermission(String token) {
		 return  authFeign.getTokenValidity(token);
	 } 
	 
	@Override
	public List<Patient> findAllPatients() {
		// TODO Auto-generated method stub
		return prepo.findAll();
	}

	@Override
	public Optional<Patient> findPatientById(int id) {
		// TODO Auto-generated method stub
		return prepo.findById(id);
	}

	@Override
	public Patient createPatient(Patient p) {
		// TODO Auto-generated method stub
		return prepo.save(p);
	}

	@Override
	public void deletePatient(int id) {
		// TODO Auto-generated method stub
		prepo.deleteById(id);
	}

	@Override
	public Patient updatePatient(int id, Patient p) {
		// TODO Auto-generated method stub
		Optional<Patient> pat = findPatientById(id);
	    if (pat.isPresent()) {
	    	Patient p1=pat.get();
	    	p1.setPname(p.getPname());
	    	p1.setPhone(p.getPhone());
	    	p1.setAddress(p.getAddress());
	    	return prepo.save(p1);
	    }
	    return null;
	}
	
	
	
	
}
