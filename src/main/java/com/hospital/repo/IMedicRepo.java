package com.hospital.repo;

import com.hospital.model.Medic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicRepo extends IGenericRepo<Medic, Integer> {
}
