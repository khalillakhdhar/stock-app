package com.elitetech.springsecurity.service;


import com.elitetech.springsecurity.entity.Fournisseur;
import com.elitetech.springsecurity.repository.FournisseurRepository;
import com.elitetech.springsecurity.service.interfaces.FournisseurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FournisseurServiceImpl implements FournisseurService {
    @Autowired private FournisseurRepository repo;

    public Fournisseur save(Fournisseur f) { return repo.save(f); }
    public List<Fournisseur> getAll() { return repo.findAll(); }
    public Optional<Fournisseur> getById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
    @Override
    public long countFournisseurs() {
        return repo.count();
    }
    
}