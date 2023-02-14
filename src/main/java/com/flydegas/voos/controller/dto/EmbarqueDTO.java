package com.flydegas.voos.controller.dto;

import com.flydegas.voos.model.AviaoModel;

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
	
	public String getPrefixo() {
		return prefixo;
	}
	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getNumPassageiros() {
		return numPassageiros;
	}
	public void setNumPassageiros(int numPassageiros) {
		this.numPassageiros = numPassageiros;
	}
	
	

}
