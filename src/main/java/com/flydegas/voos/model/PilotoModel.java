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
    @Column(nullable = false, length = 250)
    private String nome;
    @Column(nullable = false, unique = true)
    private String numeroLicenca;
    @Column(nullable = false)
    private int idade;
    @Column(nullable = false)
    private int anoExperiencia;
    @ManyToMany(mappedBy = "pilotos")
    private List<AviaoModel> avioes;
    @OneToMany(mappedBy = "piloto")
    private List<AgendaModel> agendas;
}
