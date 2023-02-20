package com.flydegas.api.dtos.forms;

import lombok.Data;

@Data
public class PilotoForm {
    private String nome;
    private String numeroLicenca;
    private int idade;
    private int anoExperiencia;
}
