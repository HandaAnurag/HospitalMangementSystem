package com.cg.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.entity.PatientDTO;
 
@FeignClient(name="PatientService-HospitalManagement",url="${PATIENT_SERVICE:http://localhost:5002}")
public interface PatientFeignClient {
      @GetMapping("/api/patients/{id}")
      public PatientDTO getPatientById(@PathVariable int id);
}