package com.elitetech.springsecurity.controller;

import com.elitetech.springsecurity.entity.Materiel;
import com.elitetech.springsecurity.service.interfaces.MaterielService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materiels")
public class MaterielController {

    @Autowired
    private MaterielService materielService;

    @GetMapping
    public List<Materiel> getAllMateriels() {
        return materielService.getAllMateriels();
    }

    @GetMapping("/{id}")
    public Materiel getMaterielById(@PathVariable Long id) {
        return materielService.getMaterielById(id).orElseThrow(() -> new RuntimeException("Matériel non trouvé"));
    }

    @PostMapping("/add")
    public Materiel addMateriel(@RequestBody Materiel materiel) {
        return materielService.addMateriel(materiel);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMateriel(@PathVariable Long id) {
        materielService.deleteMateriel(id);
    }

    @PutMapping("/stock/add/{id}/{quantity}")
    public Materiel addStock(@PathVariable Long id, @PathVariable int quantity) {
        return materielService.updateStock(id, quantity, true);
    }

    @PutMapping("/stock/remove/{id}/{quantity}")
    public Materiel removeStock(@PathVariable Long id, @PathVariable int quantity) {
        return materielService.updateStock(id, quantity, false);
    }

}
