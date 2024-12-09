package com.cg.__SpringRest_Hello;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.model.Patient;
import com.cg.service.IPatientService;
@ExtendWith(MockitoExtension.class)
public class PatientController {


@Mock
private IPatientService patientservice;

@InjectMocks
private PatientController patientController;
private Patient patient;

@BeforeEach
void setUp() {
    patient = new Patient(1, "xyz", 8271, "MBBS");
}

   @Test
    void testGetAllPatients() {
        when(patientservice.findAllPatients()).thenReturn(Arrays.asList(patient));
        var patients = patientservice.findAllPatients();
        assertFalse(patients.isEmpty());
        assertEquals(1, patients.size());
        assertEquals("xyz", patients.get(0).getPname());
    }

}
