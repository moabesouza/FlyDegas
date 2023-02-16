package com.flydegas.voos.controller.dto.cadastros;

import com.flydegas.voos.model.AviaoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastroAviaoDTO {
	private String prefixo;
	private String modelo;
	private int ano;
	private int autonomia;
	private int numPassageiros;
	
	public CadastroAviaoDTO(AviaoModel A) {
		super();
		this.prefixo = A.getPrefixo();
		this.modelo = A.getModelo();
		this.ano = A.getAno();
		this.autonomia = A.getAutonomia();
		this.numPassageiros = A.getNumPassageiros();
	}


}
