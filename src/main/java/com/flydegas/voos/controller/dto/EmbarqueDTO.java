package com.flydegas.voos.controller.dto;

import com.flydegas.voos.model.AviaoModel;
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
