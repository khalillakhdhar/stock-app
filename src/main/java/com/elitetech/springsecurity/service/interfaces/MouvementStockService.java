package com.elitetech.springsecurity.service.interfaces;

import com.elitetech.springsecurity.entity.MouvementStock;

import java.util.List;

public interface MouvementStockService {
    MouvementStock save(MouvementStock m);
    List<MouvementStock> getAll();
    MouvementStock getById(Long id);
    void delete(Long id);
}