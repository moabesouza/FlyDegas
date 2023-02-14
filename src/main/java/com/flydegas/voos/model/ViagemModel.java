package com.flydegas.voos.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "viagem")
public class ViagemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "agenda_id")
    private AgendaModel agenda;
    @ManyToOne
    @JoinColumn(name = "voo_id")
    private VooModel voo;
    @ManyToOne
    @JoinColumn(name = "passageiro_id")
    private PassageiroModel passageiro;


}
