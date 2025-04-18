package com.elitetech.springsecurity.entity;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
public class UserInfo {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
    private String name;
    private String email;
    private String roles;
    private String password;
    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnoreProperties("utilisateur")

    private List<MouvementStock> mouvementStocks;
}
