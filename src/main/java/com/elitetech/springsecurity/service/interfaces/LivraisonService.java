package com.elitetech.springsecurity.service.interfaces;


import com.elitetech.springsecurity.entity.Livraison;

import java.util.List;

public interface LivraisonService {
    Livraison save(Livraison l);
    List<Livraison> getAll();
    Livraison getById(Long id);
    void delete(Long id);
}
