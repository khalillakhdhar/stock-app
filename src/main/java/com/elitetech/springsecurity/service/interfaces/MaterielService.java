package com.elitetech.springsecurity.service.interfaces;

import com.elitetech.springsecurity.entity.Materiel;

import java.util.List;
import java.util.Optional;

public interface MaterielService {
    List<Materiel> getAllMateriels();
    Optional<Materiel> getMaterielById(Long id);
    Materiel addMateriel(Materiel materiel);
    void deleteMateriel(Long id);
    Materiel updateMateriel(Materiel materiel);
    long countMateriels();
    double getStockCritiquePercentage();

    Materiel updateStock(Long id, int quantity, boolean isAddition);
}
