package com.flydegas.voos.controller.dtos.cadastros;

import com.flydegas.voos.model.AviaoModel;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class CadastroAviaoDTO {
	private String prefixo;
	private String modelo;
	private int ano;
	private int autonomia;
	private int numPassageiros;

	
	public CadastroAviaoDTO(@NotNull AviaoModel A) {
		super();
		this.prefixo = A.getPrefixo();
		this.modelo = A.getModelo();
		this.ano = A.getAno();
		this.autonomia = A.getAutonomia();
		this.numPassageiros = A.getNumPassageiros();

	}


}
