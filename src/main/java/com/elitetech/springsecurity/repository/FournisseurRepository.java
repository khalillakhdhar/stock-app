package com.elitetech.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elitetech.springsecurity.entity.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

}
