package com.flydegas.voos.controller.dtos.cadastros;

import lombok.Data;

@Data
public class CadastroPilotoDTO {
    private String nome;
    private String numeroLicenca;
    private int idade;
    private int anoExperiencia;
}
