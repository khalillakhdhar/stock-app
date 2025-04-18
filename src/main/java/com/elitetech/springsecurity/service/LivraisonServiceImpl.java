package com.elitetech.springsecurity.service;

import com.elitetech.springsecurity.entity.Livraison;
import com.elitetech.springsecurity.repository.LivraisonRepository;
import com.elitetech.springsecurity.service.interfaces.LivraisonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivraisonServiceImpl implements LivraisonService {
    @Autowired private LivraisonRepository repo;

    public Livraison save(Livraison l) { return repo.save(l); }
    public List<Livraison> getAll() { return repo.findAll(); }
    public Livraison getById(Long id) { return repo.findById(id).orElse(null); }
    public void delete(Long id) { repo.deleteById(id); }
}
