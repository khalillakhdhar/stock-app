package com.elitetech.springsecurity.controller;


import com.elitetech.springsecurity.entity.MouvementStock;
import com.elitetech.springsecurity.service.interfaces.MouvementStockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mouvements")
public class MouvementStockController {

    @Autowired
    private MouvementStockService service;

    @GetMapping
    public List<MouvementStock> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MouvementStock> getById(@PathVariable Long id) {
        MouvementStock m = service.getById(id);
        return m != null ? ResponseEntity.ok(m) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public MouvementStock create(@RequestBody MouvementStock m) {
        return service.save(m);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MouvementStock> update(@PathVariable Long id, @RequestBody MouvementStock m) {
        m.setId(id);
        return ResponseEntity.ok(service.save(m));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}