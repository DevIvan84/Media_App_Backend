package com.hospital.service.impl;

import com.hospital.model.Medic;
import com.hospital.repo.IGenericRepo;
import com.hospital.repo.IMedicRepo;
import com.hospital.service.IMedicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicServiceImpl extends CRUDImpl<Medic, Integer> implements IMedicService {

    private final IMedicRepo repo;


    @Override
    protected IGenericRepo<Medic, Integer> getRepo() {
        return repo;
    }
}
