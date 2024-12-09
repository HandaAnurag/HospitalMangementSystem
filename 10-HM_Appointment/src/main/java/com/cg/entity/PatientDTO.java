package com.cg.entity;


import jakarta.persistence.Column;

public class PatientDTO {
	
	private int id;
	public String pname;
	public int phone;
	public String address;
	

	public PatientDTO(int id, String pname, int phone, String address) {
		super();
		this.id = id;
		this.pname = pname;
		this.phone = phone;
		this.address = address;
	}

	public PatientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "PatientDTO [id=" + id + ", pname=" + pname + ", phone=" + phone + ", address=" + address + "]";
	}


}
