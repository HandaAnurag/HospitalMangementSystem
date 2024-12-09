package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.entity.AppointmentDTO;
import com.cg.model.Appointment;

public interface IAppointmentService {
	public List<Appointment> findAllAppointments() ;
	public Optional<Appointment>findAppoinmentById (int id);
	public Appointment createAppointment(Appointment ap);
	public void deleteAppointment(int id);
	public Appointment updateAppointment(int id,Appointment ap);
	public AppointmentDTO getAppointmentWithDoctorAndPatient(int appointmentId);
	public boolean hasPermission(String token);
}
