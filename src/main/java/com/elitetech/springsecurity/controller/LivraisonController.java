package com.elitetech.springsecurity.controller;


import com.elitetech.springsecurity.entity.Livraison;
import com.elitetech.springsecurity.service.interfaces.LivraisonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/livraisons")
public class LivraisonController {

    @Autowired
    private LivraisonService service;

    @GetMapping
    public ResponseEntity<List<Livraison>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Livraison> create(@RequestBody Livraison l) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(l));
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
