package com.flydegas.voos.controller.dto;

import com.flydegas.voos.model.AviaoModel;

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
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getAutonomia() {
		return autonomia;
	}
	public void setAutonomia(int autonomia) {
		this.autonomia = autonomia;
	}
	public int getNumPassageiros() {
		return numPassageiros;
	}
	public void setNumPassageiros(int numPassageiros) {
		this.numPassageiros = numPassageiros;
	}
	
	

}
