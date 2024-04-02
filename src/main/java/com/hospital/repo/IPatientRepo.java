package com.hospital.repo;

import com.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepo extends IGenericRepo<Patient, Integer> {
}
