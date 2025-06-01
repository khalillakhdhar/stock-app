package com.elitetech.springsecurity.controller;


import com.elitetech.springsecurity.entity.Fournisseur;
import com.elitetech.springsecurity.service.interfaces.FournisseurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/fournisseurs")
public class FournisseurController {

    @Autowired
    private FournisseurService service;
    @GetMapping("/count")
    public ResponseEntity<Long> countFournisseurs() {
        return ResponseEntity.ok(service.countFournisseurs());
    }

    @GetMapping
    public ResponseEntity<List<Fournisseur>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Fournisseur> create(@RequestBody Fournisseur f) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(f));
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
