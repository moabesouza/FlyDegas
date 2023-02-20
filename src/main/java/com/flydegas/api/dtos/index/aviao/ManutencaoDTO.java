package com.flydegas.api.dtos.index.aviao;

import com.flydegas.api.model.AviaoModel;
import lombok.Data;

@Data
public class ManutencaoDTO {
	private String prefixo;
	private String modelo;
	private int ano;
	private int autonomia;
	
	public ManutencaoDTO() {
		super();
	
	}
	
	public ManutencaoDTO(AviaoModel A) {
		super();
		this.prefixo = A.getPrefixo();
		this.modelo = A.getModelo();
		this.ano = A.getAno();
		this.autonomia = A.getAutonomia();
	}

}
