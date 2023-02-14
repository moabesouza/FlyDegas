package com.flydegas.voos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data // gerar gets sets
@Table(name = "voo")
public class VooModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//gerar id automaticamente
    private Long voo_id;
    @ManyToOne
    @JoinColumn(name = "aviao_id")
    private AviaoModel aviao;

    @ManyToOne
    @JoinColumn(name = "aeroporto_saida_id")
    private AeroportoModel aeroportoSaida;
    @ManyToOne
    @JoinColumn(name = "aeroporto_chegada_id")
    private AeroportoModel aeroportoChegada;
    @Column(nullable = false)
    private LocalDate data;
    @Column(nullable = false)
    private LocalTime horaSaida;
    @Column(nullable = false)
    private LocalTime horaChegada;

    @OneToMany(mappedBy = "voo")
    private List<ViagemModel> viagens;
}
