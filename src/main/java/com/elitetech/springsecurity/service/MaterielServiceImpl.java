package com.elitetech.springsecurity.service;

import com.elitetech.springsecurity.entity.Materiel;
import com.elitetech.springsecurity.repository.MaterielRepository;
import com.elitetech.springsecurity.service.interfaces.MaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterielServiceImpl implements MaterielService {

    @Autowired
    private MaterielRepository materielRepository;

    @Override
    public List<Materiel> getAllMateriels() {
        return materielRepository.findAll();
    }

    @Override
    public Optional<Materiel> getMaterielById(Long id) {
        return materielRepository.findById(id);
    }

    @Override
    public Materiel addMateriel(Materiel materiel) {
        return materielRepository.save(materiel);
    }

    @Override
    public void deleteMateriel(Long id) {
        materielRepository.deleteById(id);
    }

    @Override
    public Materiel updateMateriel(Materiel materiel) {
        return materielRepository.save(materiel);
    }

    @Override
    public Materiel updateStock(Long id, int quantity, boolean isAddition) {
        Materiel materiel = materielRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matériel non trouvé avec l'ID : " + id));

        if (isAddition) {
            materiel.setQuantite(materiel.getQuantite() + quantity);
        } else {
            int newQuantity = materiel.getQuantite() - quantity;
            if (newQuantity < 0) {
                throw new IllegalArgumentException("Quantité insuffisante pour retirer " + quantity);
            }
            materiel.setQuantite(newQuantity);
        }

        return materielRepository.save(materiel);
    }
}
