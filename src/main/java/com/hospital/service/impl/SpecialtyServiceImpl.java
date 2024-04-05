package com.hospital.service.impl;

import com.hospital.model.Specialty;
import com.hospital.repo.IGenericRepo;
import com.hospital.repo.ISpecialtyRepo;
import com.hospital.service.ISpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class SpecialtyServiceImpl extends CRUDImpl<Specialty, Integer> implements ISpecialtyService {

    //@Autowired
    private final ISpecialtyRepo repo;// = new SpecialtyRepo();


    @Override
    protected IGenericRepo<Specialty, Integer> getRepo() {
        return repo;
    }
}
