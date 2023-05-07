package com.flydegas.api.dtos.index.aviao;

import com.flydegas.api.model.AviaoModel;
import lombok.Data;

@Data
public class AviaoDTO {

    private Long id;
    private String prefixo;
    private String modelo;
    private int ano;
    private int autonomia;
    private int numPassageiros;

    public AviaoDTO() {}

    public AviaoDTO(AviaoModel aviao) {
        this.id = aviao.getAviao_id();
        this.prefixo = aviao.getPrefixo();
        this.modelo = aviao.getModelo();
        this.ano = aviao.getAno();
        this.autonomia = aviao.getAutonomia();
        this.numPassageiros = aviao.getNumPassageiros();
    }
}
