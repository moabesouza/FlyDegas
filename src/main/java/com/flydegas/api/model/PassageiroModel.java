package com.flydegas.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "passageiro")
public class PassageiroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passageiro_id;
    @Column(nullable = false, length = 250)
    private String nome;
    @OneToMany(mappedBy = "passageiro")//um-para-muitos
    private List<ViagemModel> viagens;
}
