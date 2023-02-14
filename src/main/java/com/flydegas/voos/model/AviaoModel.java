package com.flydegas.voos.model;
import com.flydegas.voos.form.AviaoForm;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "aviao")
public class AviaoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aviao_id;
	private String prefixo;
	private String modelo;
	private int ano;
	private int autonomia;
	private int numPassageiros;
	@ManyToMany
	@JoinTable(
			name = "aviao_piloto",
			joinColumns = @JoinColumn(name = "aviao_id"),
			inverseJoinColumns = @JoinColumn(name = "piloto_id")
	)
	private List<PilotoModel> pilotos;

	@OneToMany(mappedBy = "aviao")
	private List<VooModel> voos;

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
}
