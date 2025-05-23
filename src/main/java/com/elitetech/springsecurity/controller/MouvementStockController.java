package com.elitetech.springsecurity.controller;


import com.elitetech.springsecurity.entity.MouvementStock;
import com.elitetech.springsecurity.service.interfaces.MouvementStockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/mouvements")
public class MouvementStockController {

    @Autowired
    private MouvementStockService service;

    @GetMapping
    public ResponseEntity<List<MouvementStock>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<MouvementStock> create(@RequestBody MouvementStock m) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(m));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
