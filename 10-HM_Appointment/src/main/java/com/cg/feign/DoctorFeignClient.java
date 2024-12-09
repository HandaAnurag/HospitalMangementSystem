package com.cg.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.entity.DoctorDTO;

@FeignClient(name="DoctorService-HospitalManagement", url="${DOCTOR_SERVICE:http://localhost:5001}",fallback = DoctorFeignClientFallback.class)
public interface DoctorFeignClient {
   @GetMapping("/api/doctors/{id}")
   public DoctorDTO getDoctorById(@PathVariable int id);	
}