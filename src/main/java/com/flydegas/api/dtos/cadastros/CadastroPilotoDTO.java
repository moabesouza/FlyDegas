package com.flydegas.api.dtos.cadastros;

import com.flydegas.api.dtos.index.piloto.PilotoDTO;
import lombok.Data;

@Data
public class CadastroPilotoDTO {
    private String nome;
    private String numeroLicenca;
    private int idade;
    private int anoExperiencia;

    public CadastroPilotoDTO(PilotoDTO pilotoDTO) {

        this.nome = pilotoDTO.getNome();
        this.numeroLicenca = pilotoDTO.getNumeroLicenca();
        this.idade = pilotoDTO.getIdade();
        this.anoExperiencia = pilotoDTO.getAnoExperiencia();
    }

    public CadastroPilotoDTO() {

    }
}
