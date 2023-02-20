package com.flydegas.api.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "viagem")
public class ViagemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long viagem_id;

    @ManyToOne
    @JoinColumn(name = "agenda_id", referencedColumnName = "agenda_id")
    private AgendaModel agenda;

    @ManyToOne
    @JoinColumn(name = "voo_id", referencedColumnName = "voo_id")
    private VooModel voo;

    @ManyToOne
    @JoinColumn(name = "passageiro_id", referencedColumnName = "passageiro_id")
    private PassageiroModel passageiro;
}
