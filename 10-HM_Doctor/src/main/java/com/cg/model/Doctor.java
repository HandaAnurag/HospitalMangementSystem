package com.cg.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Doctor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dId")
	private int id;
	
	@Column(name="dName")
	public String dname;
	
	@Column(name="qualification")
	public String qualification;
	
	
}
