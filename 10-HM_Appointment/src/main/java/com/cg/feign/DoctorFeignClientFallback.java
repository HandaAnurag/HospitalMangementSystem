package com.cg.feign;

import org.springframework.stereotype.Component;

import com.cg.entity.DoctorDTO;

@Component
public class DoctorFeignClientFallback implements DoctorFeignClient {
    @Override
    public DoctorDTO getDoctorById(int id) {
       
        return new DoctorDTO();  // return empty or default Doctor
    }
}
