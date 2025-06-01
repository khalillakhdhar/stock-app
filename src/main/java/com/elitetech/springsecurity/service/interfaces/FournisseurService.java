package com.elitetech.springsecurity.service.interfaces;


import com.elitetech.springsecurity.entity.Fournisseur;

import java.util.List;
import java.util.Optional;

public interface FournisseurService {
    Fournisseur save(Fournisseur f);
    List<Fournisseur> getAll();
    Optional<Fournisseur> getById(Long id);
    void delete(Long id);
    long countFournisseurs();

}