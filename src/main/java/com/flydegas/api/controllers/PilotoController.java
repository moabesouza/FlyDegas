package com.flydegas.api.controllers;

import com.flydegas.api.dtos.cadastros.CadastroPilotoDTO;

import com.flydegas.api.dtos.index.piloto.PilotoDTO;

import com.flydegas.api.services.PilotoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/piloto")
public class PilotoController {

    private final PilotoService pilotoService;

    @Autowired
    public PilotoController(PilotoService pilotoService) {
        this.pilotoService = pilotoService;
    }


    @PostMapping
    public ResponseEntity<PilotoDTO> criar(@RequestBody @Valid CadastroPilotoDTO cadastroPilotoDTO) {
        PilotoDTO pilotoDTO = pilotoService.criar(cadastroPilotoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pilotoDTO);
    }

    @GetMapping("/cadastrar")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("cadastroPilotoDTO", new CadastroPilotoDTO());
        return "cadastro-piloto";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute("cadastroPilotoDTO") @Valid CadastroPilotoDTO cadastroPilotoDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "cadastro-piloto";
        }
        pilotoService.criar(cadastroPilotoDTO);
        return "redirect:/piloto/consultar";
    }

    @GetMapping("/consultar")
    public String listarTodos(Model model) {
        List<PilotoDTO> pilotosDTO = pilotoService.listarTodos();
        model.addAttribute("pilotos", pilotosDTO);
        return "consulta-piloto";
    }


    @GetMapping("/excluir/{id}")
    public String exibirPaginaExclusao(@PathVariable("id") Long id, Model model) {
        // busca o piloto pelo id
        PilotoDTO piloto = pilotoService.buscarPorId(id);

        // adiciona o piloto ao model
        model.addAttribute("piloto", piloto);

        return "excluir-piloto"; // retorna a página de exclusão de piloto
    }

    // mapeamento para exclusão do piloto
    @PostMapping("/excluir/{id}")
    public String excluirPiloto(@PathVariable("id") Long id) {
        // exclui o piloto pelo id
        pilotoService.deletar(id);

        return "redirect:/piloto/consultar"; // redireciona para a página de listagem de pilotos
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEditarPiloto(@PathVariable Long id, Model model) {
        PilotoDTO pilotoDTO = pilotoService.buscarPorId(id);
        CadastroPilotoDTO cadastroPilotoDTO = new CadastroPilotoDTO(pilotoDTO);
        model.addAttribute("cadastroPilotoDTO", cadastroPilotoDTO);
        model.addAttribute("idPiloto", id);
        return "editar-piloto";
    }

    @PostMapping ("/editar/{id}")
    public String atualizarPiloto(@PathVariable Long id, @ModelAttribute @Valid CadastroPilotoDTO cadastroPilotoDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editar-piloto";
        }
        pilotoService.atualizar(id, cadastroPilotoDTO);
        return "redirect:/piloto/consultar";
    }


    @GetMapping("/detalhe/{id}")
    public String detalhes(@PathVariable Long id, Model model) {
        PilotoDTO piloto = pilotoService.buscarPorId(id);
        model.addAttribute("piloto", piloto);
        return "detalhe-piloto";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
        try {
            PilotoDTO pilotoDTO = pilotoService.buscarPorId(id);
            return ResponseEntity.ok(pilotoDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @GetMapping("/licenca/{numeroLicenca}")
    public ResponseEntity<Object> buscarPorNumeroLicenca(@PathVariable String numeroLicenca) {
        try {
            PilotoDTO pilotoDTO = pilotoService.buscarPorNumeroLicenca(numeroLicenca);
            return ResponseEntity.ok(pilotoDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

//    @GetMapping
//    public ResponseEntity<List<PilotoDTO>> listarTodos() {
//        List<PilotoDTO> pilotosDTO = pilotoService.listarTodos();
//        return ResponseEntity.ok(pilotosDTO);
//    }
}
