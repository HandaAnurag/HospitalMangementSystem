package com.cg.entity;

import java.time.LocalDate;

public class AppointmentDTO {

	private int aid;           
    private String time;       
    private LocalDate date;       
    private String issue;      
    private String status;     
    private double fees;          
    private DoctorDTO doctor; 
    private PatientDTO patient;
	public AppointmentDTO(int aid, String time, LocalDate date, String issue, String status, int fees, DoctorDTO doctor,
			PatientDTO patient) {
		super();
		this.aid = aid;
		this.time = time;
		this.date = date;
		this.issue = issue;
		this.status = status;
		this.fees = fees;
		this.doctor = doctor;
		this.patient = patient;
	}
	public AppointmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double d) {
		this.fees = d;
	}
	public DoctorDTO getDoctor() {
		return doctor;
	}
	public void setDoctor(DoctorDTO doctor) {
		this.doctor = doctor;
	}
	public PatientDTO getPatient() {
		return patient;
	}
	public void setPatient(PatientDTO patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		return "AppointmentDTO [aid=" + aid + ", time=" + time + ", date=" + date + ", issue=" + issue + ", status="
				+ status + ", fees=" + fees + ", doctor=" + doctor + ", patient=" + patient + "]";
	}
    
    
}