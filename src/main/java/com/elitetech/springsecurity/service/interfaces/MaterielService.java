package com.elitetech.springsecurity.service.interfaces;

import com.elitetech.springsecurity.entity.Materiel;

import java.util.List;

public interface MaterielService {
    Materiel save(Materiel materiel);
    List<Materiel> getAll();
    Materiel getById(Long id);
    void delete(Long id);
}
