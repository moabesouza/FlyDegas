package com.flydegas.voos.form;

import com.flydegas.voos.model.AviaoModel;

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
