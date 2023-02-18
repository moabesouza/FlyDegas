package com.flydegas.voos.services;

import com.flydegas.voos.controller.dtos.cadastros.CadastroPilotoDTO;
import com.flydegas.voos.controller.dtos.index.piloto.PilotoDTO;
import com.flydegas.voos.controller.dtos.mapper.PilotoMapper;
import com.flydegas.voos.exception.ResourceNotFoundException;
import com.flydegas.voos.model.PilotoModel;
import com.flydegas.voos.repository.PilotoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PilotoService {

    private final PilotoRepository pilotoRepository;

    @Autowired
    public PilotoService(PilotoRepository pilotoRepository) {
        this.pilotoRepository = pilotoRepository;
    }

    @Autowired
    private MessageSource messageSource;

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
        PilotoModel pilotoModel = pilotoRepository.findByNumeroLicenca(numeroLicenca)
                .orElseThrow(() -> new ResourceNotFoundException(
                        messageSource.getMessage("piloto.not.found", new Object[] {numeroLicenca}, Locale.getDefault())));

        PilotoMapper mapper = new PilotoMapper();
        PilotoDTO pilotoDTO = mapper.toDTO(pilotoModel);

        return pilotoDTO;
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