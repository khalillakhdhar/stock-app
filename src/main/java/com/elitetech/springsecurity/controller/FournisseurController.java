package com.elitetech.springsecurity.controller;


import com.elitetech.springsecurity.entity.Fournisseur;
import com.elitetech.springsecurity.service.interfaces.FournisseurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseurs")
public class FournisseurController {

    @Autowired
    private FournisseurService service;

    @GetMapping
    public List<Fournisseur> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> getById(@PathVariable Long id) {
        Fournisseur f = service.getById(id);
        return f != null ? ResponseEntity.ok(f) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Fournisseur create(@RequestBody Fournisseur f) {
        return service.save(f);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fournisseur> update(@PathVariable Long id, @RequestBody Fournisseur f) {
        f.setId(id);
        return ResponseEntity.ok(service.save(f));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}