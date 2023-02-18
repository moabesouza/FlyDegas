package com.flydegas.voos.controller.dtos.index.piloto;

import com.flydegas.voos.model.PilotoModel;
import lombok.Data;

@Data
public class PilotoDTO {

    private Long id;
    private String nome;
    private String numeroLicenca;
    private int idade;
    private int anoExperiencia;

    public PilotoDTO() {
    }

    public PilotoDTO(PilotoModel piloto) {
        this.id = piloto.getPiloto_id();
        this.nome = piloto.getNome();
        this.numeroLicenca = piloto.getNumeroLicenca();
        this.idade = piloto.getIdade();
        this.anoExperiencia = piloto.getAnoExperiencia();
    }


}

