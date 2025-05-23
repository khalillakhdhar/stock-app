package com.elitetech.springsecurity.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Materiel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private int quantiteStock;
    private int seuilCritique;
    private int quantite;

    @OneToMany(mappedBy = "materiel", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("matriel")
    private List<MouvementStock> mouvements;

    @OneToMany(mappedBy = "materiel", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("matriel")
    private List<Livraison> livraisons;
}
