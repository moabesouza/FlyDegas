package com.flydegas.voos.model;
import jakarta.persistence.*;
import lombok.*; // gerar gets sets

import java.util.List;

@Entity
@Data // gerar gets sets
@Table(name = "piloto")
public class PilotoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long piloto_id;
    private String nome;
    private String numeroLicenca;
    private int idade;
    private int experiencia;
    @ManyToMany(mappedBy = "pilotos")
    private List<AviaoModel> avioes;
    @OneToMany(mappedBy = "piloto")
    private List<AgendaModel> agendas;
}
