package com.hospital.controller;


import com.hospital.model.Medic;
import com.hospital.service.IMedicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${medic.controller.path}")
public class MedicController {

    private final IMedicService service;

    @GetMapping
    public ResponseEntity<List<Medic>> findAll() {
        List<Medic> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medic> findById(@PathVariable("id") Integer id) {
        Medic obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Medic> save(@RequestBody Medic Medic) {

        Medic obj = service.save(Medic);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMedic()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medic> update(@PathVariable("id") Integer id, @RequestBody Medic Medic) {
        Medic.setIdMedic(id);
        Medic obj = service.update(id,Medic);

        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){

        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
