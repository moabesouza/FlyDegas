package com.flydegas.voos.controller;

import com.flydegas.voos.controller.dtos.cadastros.CadastroPilotoDTO;
import com.flydegas.voos.controller.dtos.index.piloto.PilotoDTO;
import com.flydegas.voos.services.PilotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @GetMapping("/{id}")
    public ResponseEntity<PilotoDTO> buscarPorId(@PathVariable Long id) {
        PilotoDTO pilotoDTO = pilotoService.buscarPorId(id);
        return ResponseEntity.ok(pilotoDTO);
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

    @GetMapping
    public ResponseEntity<List<PilotoDTO>> listarTodos() {
        List<PilotoDTO> pilotosDTO = pilotoService.listarTodos();
        return ResponseEntity.ok(pilotosDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PilotoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid CadastroPilotoDTO cadastroPilotoDTO) {
        PilotoDTO pilotoDTO = pilotoService.atualizar(id, cadastroPilotoDTO);
        return ResponseEntity.ok(pilotoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pilotoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
