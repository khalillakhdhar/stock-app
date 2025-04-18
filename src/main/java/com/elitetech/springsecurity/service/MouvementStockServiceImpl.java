package com.elitetech.springsecurity.service;


import com.elitetech.springsecurity.entity.MouvementStock;
import com.elitetech.springsecurity.repository.MouvementStockRepository;
import com.elitetech.springsecurity.service.interfaces.MouvementStockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MouvementStockServiceImpl implements MouvementStockService {
    @Autowired private MouvementStockRepository repo;

    public MouvementStock save(MouvementStock m) { return repo.save(m); }
    public List<MouvementStock> getAll() { return repo.findAll(); }
    public MouvementStock getById(Long id) { return repo.findById(id).orElse(null); }
    public void delete(Long id) { repo.deleteById(id); }
}