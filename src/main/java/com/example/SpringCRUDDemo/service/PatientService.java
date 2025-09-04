package com.example.SpringCRUDDemo.service;

import com.example.SpringCRUDDemo.repository.Patient;
import com.example.SpringCRUDDemo.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Crear (guardar) un paciente
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
}