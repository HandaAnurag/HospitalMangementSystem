package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.cg.entity.AppointmentDTO;
import com.cg.entity.DoctorDTO;
import com.cg.entity.PatientDTO;
import com.cg.feign.AuthFeign;
import com.cg.feign.DoctorFeignClient;
import com.cg.feign.PatientFeignClient;
import com.cg.model.Appointment;
import com.cg.repository.AppointmentRepository;

@Service
public class AppointmentService implements IAppointmentService {

	@Autowired
	AppointmentRepository arepo;
	
	 @Autowired
	    private DoctorFeignClient doctorFeignClient;

	    @Autowired
	    private PatientFeignClient patientFeignClient;

	@Override
	public List<Appointment> findAllAppointments() {
		// TODO Auto-generated method stub
		return arepo.findAll();
	}

	@Override
	public Optional<Appointment> findAppoinmentById(int id) {
		// TODO Auto-generated method stub
		return arepo.findById(id);
	}

	@Override
	public Appointment createAppointment(Appointment ap) {
		// TODO Auto-generated method stub
		return arepo.save(ap);
	}

	@Override
	public void deleteAppointment(int id) {
		// TODO Auto-generated method stub
		arepo.deleteById(id);
	}

	@Override
	public Appointment updateAppointment(int id, Appointment ap) {
		// TODO Auto-generated method stub
		Optional<Appointment> apt = findAppoinmentById(id);
	    if (apt.isPresent()) {
	    	Appointment a=apt.get();
	    	a.setdId(ap.getdId());
	    	a.setpId(ap.getpId());
	    	a.setDate(ap.getDate());
	    	a.setTime(ap.getTime());
	    	a.setIssue(ap.getIssue());
	    	a.setStatus(ap.getStatus());
	    	a.setFees(ap.getFees());
	    	return arepo.save(a);
	    }
	    return null;
	}
	
	public AppointmentDTO getAppointmentWithDoctorAndPatient(int appointmentId) {
     
        Appointment appointment = arepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id " + appointmentId));

        
        DoctorDTO doctor = doctorFeignClient.getDoctorById(appointment.getdId());
        PatientDTO patient=patientFeignClient.getPatientById(appointment.getpId());
        
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setAid(appointment.getId());
        appointmentDTO.setTime(appointment.getTime());
        appointmentDTO.setDate(appointment.getDate());
        appointmentDTO.setIssue(appointment.getIssue());
        appointmentDTO.setStatus(appointment.getStatus());
        appointmentDTO.setFees(appointment.getFees());
        appointmentDTO.setDoctor(doctor);
        appointmentDTO.setPatient(patient);

        return appointmentDTO;
    }
	
	@Autowired(required=true)
	AuthFeign af;
	
	@Override
	public boolean hasPermission(String token) {
		boolean flag = af.getTokenValidity(token);
		System.out.println("Flag Token : " + flag);
		return flag;
	}
 
	
	
	
	
	
}
