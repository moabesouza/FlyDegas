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

	@Column(nullable = false, length = 50)
	private String prefixo;
	@Column(nullable = false, length = 250)
	private String modelo;
	@Column(nullable = false, length = 4)
	private int ano;
	@Column(nullable = false)
	private int autonomia;
	@Column(nullable = false)
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
