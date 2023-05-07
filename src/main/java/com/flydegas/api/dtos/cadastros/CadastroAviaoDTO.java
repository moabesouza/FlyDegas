package com.flydegas.api.dtos.cadastros;

import com.flydegas.api.model.AviaoModel;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class CadastroAviaoDTO {
	private String prefixo;
	private String modelo;
	private int ano;
	private int autonomia;
	private int numPassageiros;

	public CadastroAviaoDTO() {
		// construtor sem argumentos
	}

	public CadastroAviaoDTO(@NotNull AviaoModel aviao) {
		this.prefixo = aviao.getPrefixo();
		this.modelo = aviao.getModelo();
		this.ano = aviao.getAno();
		this.autonomia = aviao.getAutonomia();
		this.numPassageiros = aviao.getNumPassageiros();
	}

	public AviaoModel toAviaoModel() {
		AviaoModel aviao = new AviaoModel();
		aviao.setPrefixo(this.prefixo);
		aviao.setModelo(this.modelo);
		aviao.setAno(this.ano);
		aviao.setAutonomia(this.autonomia);
		aviao.setNumPassageiros(this.numPassageiros);
		return aviao;
	}
}
