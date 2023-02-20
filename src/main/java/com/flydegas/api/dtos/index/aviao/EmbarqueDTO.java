package com.flydegas.api.dtos.index.aviao;

import com.flydegas.api.model.AviaoModel;

import lombok.Data;


@Data
public class EmbarqueDTO {
	private String prefixo;
	private String modelo;
	private int numPassageiros;

	public EmbarqueDTO(AviaoModel A) {
		super();
		this.prefixo = A.getPrefixo();
		this.modelo = A.getModelo();
		this.numPassageiros = A.getNumPassageiros();
	}


}
