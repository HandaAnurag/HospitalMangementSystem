package com.cg.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@NotNull(message = "Id of paitent cannot be null")
	@Column(name="pId")
	private int id;
	
	@NotBlank(message = "Name of paitent cannot be blank")
	@Column(name="pName")
	public String pname;
	
	@NotNull(message = "Phone no cannot be null")
	@Column(name="phoneNo")
	public int phone;
	
	@NotBlank(message = "address cannot be blank")
	@Column(name="address")
	public String address;
	
}
