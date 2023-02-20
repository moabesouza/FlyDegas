package com.flydegas.api.model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

import java.util.List;

@Entity
@Data
@Table(name = "agenda")
public class AgendaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agenda_id;
    @Column(nullable = false)
    private LocalDate data;
    @ManyToOne
    @JoinColumn(name = "piloto_id", nullable = false)
    private PilotoModel piloto;

    @OneToMany(mappedBy = "agenda")
    private List<ViagemModel> viagens;
    @ManyToOne
    @JoinColumn(name = "voo_id")
    private VooModel voo;

}