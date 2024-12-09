package com.cg.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Appointment")

public class Appointment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="doctor_Id")
	private int dId;
	
	@Column(name="patient_Id")
	private int pId;
	
	@Column(name="Time")
	public String time;
	
	@Column(name="Date")
	public LocalDate date;
	
	@Column(name="Issue")
	public String issue;
	
	@Column(name="Status")
	public String status;
	
	@Column(name="Fees")
	public double fees;
	
	public Appointment() {
		
	}

	

	public Appointment(int id, int dId, int pId, String time, LocalDate date, String issue, String status,
			double fees) {
		super();
		this.id = id;
		this.dId = dId;
		this.pId = pId;
		this.time = time;
		this.date = date;
		this.issue = issue;
		this.status = status;
		this.fees = fees;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
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

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Appointment [id=" + id + ", dId=" + dId + ", pId=" + pId + ", time=" + time + ", date=" + date
				+ ", issue=" + issue + ", status=" + status + ", fees=" + fees + "]";
	}

	

	
	
	
	
}
