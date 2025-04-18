package com.elitetech.springsecurity.controller;


import com.elitetech.springsecurity.entity.Livraison;
import com.elitetech.springsecurity.service.interfaces.LivraisonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livraisons")
public class LivraisonController {

    @Autowired
    private LivraisonService service;

    @GetMapping
    public List<Livraison> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livraison> getById(@PathVariable Long id) {
        Livraison l = service.getById(id);
        return l != null ? ResponseEntity.ok(l) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Livraison create(@RequestBody Livraison l) {
        return service.save(l);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livraison> update(@PathVariable Long id, @RequestBody Livraison l) {
        l.setId(id);
        return ResponseEntity.ok(service.save(l));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}