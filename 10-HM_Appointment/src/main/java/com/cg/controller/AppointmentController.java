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

import com.cg.entity.AppointmentDTO;
import com.cg.entity.DoctorDTO;
import com.cg.entity.PatientDTO;
import com.cg.exception.ResourceNotFoundException;
import com.cg.feign.DoctorFeignClient;
import com.cg.feign.PatientFeignClient;
import com.cg.model.Appointment;
import com.cg.service.IAppointmentService;

@RequestMapping("/api")
@RestController
public class AppointmentController {
	
	@Autowired
	IAppointmentService appService;
    
	@Autowired
    private DoctorFeignClient doctorFeignClient;

    @Autowired
    private PatientFeignClient patientFeignClient;

	@GetMapping(path = "/appointments", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Appointment> getAppointments(){
		return appService.findAllAppointments();
	}
	
	@GetMapping("doctors/{id}")
    public DoctorDTO getDoctorById( @PathVariable int id) 
	{   
        DoctorDTO doctor = doctorFeignClient.getDoctorById(id);
        return doctor;
    }
	
	@GetMapping("patients/{id}")
    public PatientDTO getPatientById( @PathVariable int id) 
	{
		PatientDTO patient = patientFeignClient.getPatientById(id);
		return patient;
    }
	
	@GetMapping("/appointment/{id}")
	Optional<Appointment>findByAppointmentId(@PathVariable int id)
	{	
		return appService.findAppoinmentById(id);	
	}
	
	@PostMapping("/appointments")
	public Appointment createDoctor(@RequestBody Appointment ap) {
		return appService.createAppointment(ap);
	}

	@DeleteMapping("/appointments/{id}")
	public void deleteAppoinment(@PathVariable int id)
	{
	    appService.deleteAppointment(id);
	}
	
	@PutMapping("/appointments/{id}")
	public Appointment updateAppointment(@PathVariable int id, @RequestBody Appointment ap) 
	{
	    return appService.updateAppointment(id, ap);
	}
	
	
	@GetMapping("/appointments/{id}")
	public AppointmentDTO getAppointment(@PathVariable int id)
	{
		return appService.getAppointmentWithDoctorAndPatient(id);
	}

	@GetMapping("/token")
    public List<Appointment> getAllDoctor(@RequestHeader("Authorization") String token)
    {
    	if(appService.hasPermission(token))
    		return appService.findAllAppointments();
    	else
    		return null;
    }
	
}
