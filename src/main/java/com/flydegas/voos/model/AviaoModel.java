package com.flydegas.voos.model;

import com.flydegas.voos.form.AviaoForm;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "aviao")
public class AviaoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String prefixo;
	private String modelo;
	private int ano;
	private int autonomia;
	private int numPassageiros;
	
	
	public void update(AviaoForm aviaoForm) {
		this.prefixo = aviaoForm.getPrefixo();
		this.modelo = aviaoForm.getModelo();
		this.ano = aviaoForm.getAno();
		this.autonomia = aviaoForm.getAutonomia();
		this.numPassageiros = aviaoForm.getNumPassageiros();	
	}
	
	
	
	public AviaoModel() {
		super();
	
	}
	
	public AviaoModel(String prefixo, String modelo, int ano, int autonomia, int numPassageiros) {
		super();
		this.prefixo = prefixo;
		this.modelo = modelo;
		this.ano = ano;
		this.autonomia = autonomia;
		this.numPassageiros = numPassageiros;
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

	public Long getID() {
		return id;
	}

	public void setID(Long iD) {
		id = iD;
	}
	
	
	

}
