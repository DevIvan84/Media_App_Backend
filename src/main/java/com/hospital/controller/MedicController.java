package com.hospital.controller;


import com.hospital.dto.MedicDTO;
import com.hospital.model.Medic;

import com.hospital.service.IMedicService;

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
@RequestMapping("/medics")
public class MedicController {

    private final IMedicService service;

    @Qualifier("medicMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<MedicDTO>> findAll() {
        List<MedicDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicDTO> findById(@PathVariable("id") Integer id) {
        Medic obj = service.findById(id);
        return ResponseEntity.ok(this.convertToDto(obj));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody MedicDTO dto) {

        Medic obj = service.save(this.convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMedic()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicDTO> update(@PathVariable("id") Integer id, @RequestBody MedicDTO dto) {
        dto.setIdMedic(id);
        Medic obj = service.update(id,this.convertToEntity(dto));

        return ResponseEntity.ok(this.convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){

        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<MedicDTO> findByIdHateoas(@PathVariable("id") Integer id) {
        EntityModel<MedicDTO> resource = EntityModel.of(convertToDto(service.findById(id)));

        //generar links informativos
        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).findById(id));
        WebMvcLinkBuilder link2 = linkTo(methodOn(this.getClass()).findAll());

        resource.add(link1.withRel("Medic-info-byId"));
        resource.add(link2.withRel("Medic-all-info"));

        return resource;
    }

    private MedicDTO convertToDto(Medic obj) {
        return modelMapper.map(obj, MedicDTO.class);
    }

    private Medic convertToEntity(MedicDTO dto) {
        return modelMapper.map(dto, Medic.class);
    }

}
