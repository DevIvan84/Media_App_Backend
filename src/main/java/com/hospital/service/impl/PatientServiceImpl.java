package com.hospital.service.impl;

import com.hospital.model.Patient;
import com.hospital.repo.IGenericRepo;
import com.hospital.repo.IPatientRepo;
import com.hospital.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl extends CRUDImpl<Patient, Integer> implements IPatientService {

    private final IPatientRepo repo;


    @Override
    protected IGenericRepo<Patient, Integer> getRepo() {
        return repo;
    }
}
