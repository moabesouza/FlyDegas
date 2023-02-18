package com.flydegas.voos.services;

import com.flydegas.voos.controller.dtos.cadastros.CadastroPilotoDTO;
import com.flydegas.voos.controller.dtos.index.piloto.PilotoDTO;
import com.flydegas.voos.model.PilotoModel;
import com.flydegas.voos.repository.PilotoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PilotoService {

    private final PilotoRepository pilotoRepository;

    @Autowired
    public PilotoService(PilotoRepository pilotoRepository) {
        this.pilotoRepository = pilotoRepository;
    }

    public PilotoDTO criar(CadastroPilotoDTO cadastroPilotoDTO) {
        PilotoModel piloto = new PilotoModel();
        piloto.setNome(cadastroPilotoDTO.getNome());
        piloto.setNumeroLicenca(cadastroPilotoDTO.getNumeroLicenca());
        piloto.setIdade(cadastroPilotoDTO.getIdade());
        piloto.setAnoExperiencia(cadastroPilotoDTO.getAnoExperiencia());

        PilotoModel pilotoSalvo = pilotoRepository.save(piloto);
        return new PilotoDTO(pilotoSalvo);
    }

    public PilotoDTO buscarPorId(Long id) {
        PilotoModel piloto = pilotoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Piloto não encontrado com o ID: " + id));
        return new PilotoDTO(piloto);
    }

    public PilotoDTO buscarPorNumeroLicenca(String numeroLicenca) {
        PilotoModel piloto = pilotoRepository.findByNumeroLicenca(numeroLicenca).orElseThrow(() -> new EntityNotFoundException("Piloto não encontrado com a Licença: " + numeroLicenca));
        return new PilotoDTO(piloto);
    }

    public List<PilotoDTO> listarTodos() {
        List<PilotoModel> pilotos = pilotoRepository.findAll();
        return pilotos.stream().map(PilotoDTO::new).collect(Collectors.toList());
    }

    public PilotoDTO atualizar(Long id, CadastroPilotoDTO cadastroPilotoDTO) {
        PilotoModel piloto = pilotoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Piloto não encontrado com o ID: " + id));
        piloto.setNome(cadastroPilotoDTO.getNome());
        piloto.setNumeroLicenca(cadastroPilotoDTO.getNumeroLicenca());
        piloto.setIdade(cadastroPilotoDTO.getIdade());
        piloto.setAnoExperiencia(cadastroPilotoDTO.getAnoExperiencia());

        PilotoModel pilotoAtualizado = pilotoRepository.save(piloto);
        return new PilotoDTO(pilotoAtualizado);
    }

    public void deletar(Long id) {
        PilotoModel piloto = pilotoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Piloto não encontrado com o ID: " + id));
        pilotoRepository.delete(piloto);
    }
}