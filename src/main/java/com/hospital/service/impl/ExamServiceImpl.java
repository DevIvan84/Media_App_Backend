package com.hospital.service.impl;

import com.hospital.model.Exam;
import com.hospital.repo.IGenericRepo;
import com.hospital.repo.IExamRepo;
import com.hospital.service.IExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class ExamServiceImpl extends CRUDImpl<Exam, Integer> implements IExamService {

    //@Autowired
    private final IExamRepo repo;// = new ExamRepo();


    @Override
    protected IGenericRepo<Exam, Integer> getRepo() {
        return repo;
    }
}