package com.elitetech.springsecurity.controller;


import com.elitetech.springsecurity.entity.Materiel;
import com.elitetech.springsecurity.service.MaterielServiceImpl;
import com.elitetech.springsecurity.service.interfaces.MaterielService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materiels")
public class MaterielController {

    @Autowired
    private MaterielService service;

    @GetMapping
    public List<Materiel> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materiel> getById(@PathVariable Long id) {
        Materiel materiel = service.getById(id);
        return materiel != null ? ResponseEntity.ok(materiel) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Materiel create(@RequestBody Materiel materiel) {
        return service.save(materiel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materiel> update(@PathVariable Long id, @RequestBody Materiel materiel) {
        materiel.setId(id);
        return ResponseEntity.ok(service.save(materiel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
