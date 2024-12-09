package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.model.Patient;

public interface IPatientService {
	public List<Patient> findAllPatients() ;
	public Optional<Patient>findPatientById (int id);
	public Patient createPatient(Patient p);
	public void deletePatient(int id);
	public Patient updatePatient(int id,Patient p);
	public boolean hasPermission(String token);
}
