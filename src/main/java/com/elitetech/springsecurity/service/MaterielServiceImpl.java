package com.elitetech.springsecurity.service;


import com.elitetech.springsecurity.entity.Materiel;
import com.elitetech.springsecurity.repository.MaterielRepository;
import com.elitetech.springsecurity.service.interfaces.MaterielService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterielServiceImpl implements MaterielService {
    @Autowired private MaterielRepository repo;

    public Materiel save(Materiel m) { return repo.save(m); }
    public List<Materiel> getAll() { return repo.findAll(); }
    public Materiel getById(Long id) { return repo.findById(id).orElse(null); }
    public void delete(Long id) { repo.deleteById(id); }
}