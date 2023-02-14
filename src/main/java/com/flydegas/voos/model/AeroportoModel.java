package com.flydegas.voos.model;

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
    private String nome;
    private String cidade;
    private String pais;
    @OneToMany(mappedBy = "aeroportoSaida")
    private List<VooModel> voosSaida;
    @OneToMany(mappedBy = "aeroportoChegada")
    private List<VooModel> voosChegada;
}
