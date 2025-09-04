package com.example.SpringCRUDDemo.controller;

import com.example.SpringCRUDDemo.repository.Patient;
import com.example.SpringCRUDDemo.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

import com.github.javafaker.Faker;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;
    private final Faker faker = new Faker(new Locale("es")); // Faker en español

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // GET /patients -> lista todos los pacientes
    @GetMapping
    public List<Patient> getPatients() {
        return patientService.getAllPatients();
    }

    // POST /patients -> crear un nuevo paciente
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @PostMapping("/fake")
    public Patient createMockPatient() {
        Patient fakePatient = new Patient(
                faker.name().fullName(),
                faker.idNumber().valid(),
                faker.number().numberBetween(18, 90),
                faker.demographic().sex()
        );
        return patientService.savePatient(fakePatient);
    }

}