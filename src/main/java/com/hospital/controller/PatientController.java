package com.hospital.controller;


import com.hospital.dto.PatientDTO;
import com.hospital.model.Patient;
import com.hospital.service.IPatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController  {

    private final IPatientService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PatientDTO>> findAll() {
        List<PatientDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> findById(@PathVariable("id") Integer id) {
        Patient obj = service.findById(id);
        return ResponseEntity.ok(this.convertToDto(obj));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody PatientDTO dto) {

        Patient obj = service.save(this.convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPatient()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody PatientDTO dto) {
        dto.setIdPatient(id);
        Patient obj = service.update(id,this.convertToEntity(dto));

        return ResponseEntity.ok(this.convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){

        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<PatientDTO> findByIdHateoas(@PathVariable("id") Integer id) {
        EntityModel<PatientDTO> resource = EntityModel.of(convertToDto(service.findById(id)));

        //generar links informativos
        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).findById(id));
        WebMvcLinkBuilder link2 = linkTo(methodOn(this.getClass()).findAll());

        resource.add(link1.withRel("patient-info-byId"));
        resource.add(link2.withRel("patient-all-info"));

        return resource;
    }

    private PatientDTO convertToDto(Patient obj) {
        return modelMapper.map(obj, PatientDTO.class);
    }

    private Patient convertToEntity(PatientDTO dto) {
        return modelMapper.map(dto, Patient.class);
    }



}
