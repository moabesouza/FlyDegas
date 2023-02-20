package com.flydegas.api.dtos.index.piloto;

import com.flydegas.api.model.PilotoModel;
import lombok.Data;

@Data
public class PilotoDTO {

    private Long piloto_id;
    private String nome;
    private String numeroLicenca;
    private int idade;
    private int anoExperiencia;

    public PilotoDTO() {
    }

    public PilotoDTO(PilotoModel piloto) {
        this.piloto_id = piloto.getPiloto_id();
        this.nome = piloto.getNome();
        this.numeroLicenca = piloto.getNumeroLicenca();
        this.idade = piloto.getIdade();
        this.anoExperiencia = piloto.getAnoExperiencia();
    }


}

