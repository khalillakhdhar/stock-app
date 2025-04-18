package com.elitetech.springsecurity.service.interfaces;


import com.elitetech.springsecurity.entity.Fournisseur;

import java.util.List;

public interface FournisseurService {
    Fournisseur save(Fournisseur f);
    List<Fournisseur> getAll();
    Fournisseur getById(Long id);
    void delete(Long id);
}