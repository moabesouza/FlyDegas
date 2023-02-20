package com.flydegas.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "aeroporto")
public class AeroportoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aeroporto_id;
    @Column(nullable = false, length = 250)
    private String nome;
    @Column(nullable = false, length = 250)
    private String cidade;
    @Column(nullable = false, length = 250)
    private String pais;
    @OneToMany(mappedBy = "aeroportoSaida")
    private List<VooModel> voosSaida;
    @OneToMany(mappedBy = "aeroportoChegada")
    private List<VooModel> voosChegada;
}
