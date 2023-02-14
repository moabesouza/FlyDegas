package com.flydegas.voos.controller;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.flydegas.voos.controller.dto.CadastroAviaoDTO;
import com.flydegas.voos.controller.dto.EmbarqueDTO;
import com.flydegas.voos.controller.dto.ManutencaoDTO;
import com.flydegas.voos.form.AviaoForm;
import com.flydegas.voos.model.*;
import com.flydegas.voos.repository.AviaoRepository;
@RestController
@RequestMapping("/aviao/")
public class AviaoController {
	
	@Autowired
	private AviaoRepository AviaoRepository;
	
	@GetMapping
	@RequestMapping("embarque/")
	public ArrayList<EmbarqueDTO> Embarque_List (String modelo){
		ArrayList<EmbarqueDTO> lista = new ArrayList<EmbarqueDTO>();
		ArrayList<AviaoModel> embarque;
		if(modelo == null) {
			embarque = (ArrayList<AviaoModel>)AviaoRepository.findAll();
		}else {
			embarque = (ArrayList<AviaoModel>)AviaoRepository.findByModelo(modelo);
		}
		for (AviaoModel e:embarque)
			lista.add(new EmbarqueDTO(e));
		return lista;
		
//		lista.add(new EmbarqueDTO(new AviaoModel(1, "Embraer E-190", 2022, 100, 200)));
//	    lista.add(new EmbarqueDTO(new AviaoModel(2, "Boeing 747", 2020, 400, 500)));
//	    lista.add(new EmbarqueDTO(new AviaoModel(3, "Airbus A380", 2021, 300, 400)));
//	    lista.add(new EmbarqueDTO(new AviaoModel(4, "Boeing 787", 2019, 200, 300)));
//	    lista.add(new EmbarqueDTO(new AviaoModel(5, "Boeing 737", 2018, 150, 250)));
//	    lista.add(new EmbarqueDTO(new AviaoModel(6, "Embraer E-195", 2020, 100, 200)));
//	    lista.add(new EmbarqueDTO(new AviaoModel(7, "Airbus A320", 2019, 200, 300)));
//	    lista.add(new EmbarqueDTO(new AviaoModel(8, "Boeing 767", 2021, 250, 350)));
//	    lista.add(new EmbarqueDTO(new AviaoModel(9, "Airbus A330", 2020, 300, 400)));
//	    lista.add(new EmbarqueDTO(new AviaoModel(10, "Boeing 777", 2022, 350, 450)));
//		
		
	}

	@GetMapping
	@RequestMapping("manutencao/")
	public ArrayList<ManutencaoDTO> Manutencao_List (String prefixo){
		ArrayList<ManutencaoDTO> lista = new ArrayList<ManutencaoDTO>();
         ArrayList<AviaoModel> manutecao;
		
		if(prefixo == null) {
			manutecao = (ArrayList<AviaoModel>)AviaoRepository.findAll();
		}else {
			manutecao = (ArrayList<AviaoModel>)AviaoRepository.findByModelo(prefixo);
		}
		
		
		for (AviaoModel m:manutecao)
			lista.add(new ManutencaoDTO(m));
		
//		lista.add(new ManutencaoDTO(new AviaoModel(1, "Embraer E-190", 2022, 100, 200)));
//	    lista.add(new ManutencaoDTO(new AviaoModel(2, "Boeing 747", 2020, 400, 500)));
//	    lista.add(new ManutencaoDTO(new AviaoModel(3, "Airbus A380", 2021, 300, 400)));
//	    lista.add(new ManutencaoDTO(new AviaoModel(4, "Boeing 787", 2019, 200, 300)));
//	    lista.add(new ManutencaoDTO(new AviaoModel(5, "Boeing 737", 2018, 150, 250)));
//	    lista.add(new ManutencaoDTO(new AviaoModel(6, "Embraer E-195", 2020, 100, 200)));
//	    lista.add(new ManutencaoDTO(new AviaoModel(7, "Airbus A320", 2019, 200, 300)));
//	    lista.add(new ManutencaoDTO(new AviaoModel(8, "Boeing 767", 2021, 250, 350)));
//	    lista.add(new ManutencaoDTO(new AviaoModel(9, "Airbus A330", 2020, 300, 400)));
//	    lista.add(new ManutencaoDTO(new AviaoModel(10, "Boeing 777", 2022, 350, 450)));
		
		return lista;
	}
	
	@PostMapping
	public ResponseEntity <CadastroAviaoDTO> inserir (@RequestBody AviaoForm aviaoForm) {
		
		AviaoModel a = aviaoForm.ToAviao();
		AviaoRepository.save(a);
		CadastroAviaoDTO adto = new CadastroAviaoDTO(a);
		return ResponseEntity.ok(adto);
	}

	@PutMapping("{id}")
	public ResponseEntity <CadastroAviaoDTO> alterarUsuario(@PathVariable Long id, @RequestBody AviaoForm aviaoForm){
	if(AviaoRepository.existsById(id)) {
		
		AviaoModel aviao = AviaoRepository.findById(id).get();
		aviao.update(aviaoForm);
		AviaoRepository.save(aviao);
		CadastroAviaoDTO ad = new CadastroAviaoDTO(aviao);
		return ResponseEntity.ok(ad);
	}else {
		return ResponseEntity.notFound().build();
	}
	
	
	}

	@DeleteMapping("{id}")
	public ResponseEntity <CadastroAviaoDTO> deletarUsuario(@PathVariable Long id){
	if(AviaoRepository.existsById(id)) {
		AviaoModel aviao = AviaoRepository.findById(id).get();
		CadastroAviaoDTO ad = new CadastroAviaoDTO(aviao);
		AviaoRepository.delete(aviao);
		return ResponseEntity.ok(ad);
		
	}else {
		
		return ResponseEntity.badRequest().build();
	}
	}
}
