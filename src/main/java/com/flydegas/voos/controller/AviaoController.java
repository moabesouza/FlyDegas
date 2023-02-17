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
import com.flydegas.voos.controller.dtos.cadastros.CadastroAviaoDTO;
import com.flydegas.voos.controller.dtos.index.aviao.EmbarqueDTO;
import com.flydegas.voos.controller.dtos.index.aviao.ManutencaoDTO;
import com.flydegas.voos.form.AviaoForm;
import com.flydegas.voos.model.*;
import com.flydegas.voos.repository.AviaoRepository;
@RestController
@RequestMapping("/aviao")
public class AviaoController {
	
	@Autowired
	private AviaoRepository AviaoRepository;
	
	@GetMapping
	@RequestMapping("/embarque")
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

	}

	@GetMapping
	@RequestMapping("/manutencao")
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

		return lista;
	}
	
	@PostMapping
	public ResponseEntity <CadastroAviaoDTO> inserir (@RequestBody AviaoForm aviaoForm) {
		
		AviaoModel a = aviaoForm.ToAviao();
		AviaoRepository.save(a);
		CadastroAviaoDTO adto = new CadastroAviaoDTO(a);
		return ResponseEntity.ok(adto);
	}

	@PutMapping("/{id}")
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

	@DeleteMapping("/{id}")
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
