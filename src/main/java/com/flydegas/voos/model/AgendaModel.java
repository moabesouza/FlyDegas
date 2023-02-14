package com.flydegas.voos.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "agenda")
public class AgendaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
    private String destino;
    private String horarioDecolagem;
    private String horarioPouso;
    private int numeroPassageiros;
    private String rota;
    @ManyToOne //muitos-para-um
    private PilotoModel piloto;
    @ManyToOne //muitos-para-um
    private VooModel voo;
}
