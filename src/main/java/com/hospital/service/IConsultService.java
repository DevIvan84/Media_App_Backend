package com.hospital.service;

import com.hospital.model.Consult;
import com.hospital.model.Exam;

import java.util.List;

public interface IConsultService extends ICRUD<Consult, Integer> {

    Consult saveTransactional(Consult consult, List<Exam> exam);

}
