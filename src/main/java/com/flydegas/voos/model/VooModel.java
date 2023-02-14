package com.flydegas.voos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data // gerar gets sets
@Table(name = "voo")
public class VooModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//gerar id automaticamente
    private Long id;
    private String destino;
    private LocalDateTime horaPartida;
    private LocalDateTime horaChegada;
    private String numeroVoo;
    @ManyToOne //muitos-para-um
    private AviaoModel aviao;
    @OneToMany//um-para-muitos
    private List<AgendaModel> agendas;
}
