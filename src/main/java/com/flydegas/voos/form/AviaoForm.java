package com.flydegas.voos.form;

import com.flydegas.voos.model.AviaoModel;
import com.flydegas.voos.model.PilotoModel;
import lombok.Data;

@Data
public class AviaoForm {

	private String prefixo;
	private String modelo;
	private int ano;
	private int autonomia;
	private int numPassageiros;

	
	public AviaoModel ToAviao() {
		AviaoModel a = new AviaoModel();
		a.setPrefixo(prefixo);
		a.setModelo(modelo);
		a.setAno(ano);
		a.setAutonomia(autonomia);
		a.setNumPassageiros(numPassageiros);
		return a;
	}

	public String getPrefixo() {
		return prefixo;
	}
	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}
	public String getModelo() {
		return modelo;
	}

}
