package com.flydegas.api.services;

import com.flydegas.api.dtos.cadastros.CadastroPilotoDTO;
import com.flydegas.api.dtos.index.piloto.PilotoDTO;
import com.flydegas.api.dtos.mappers.PilotoMapper;
import com.flydegas.api.exception.ResourceNotFoundException;
import com.flydegas.api.models.PilotoModel;
import com.flydegas.api.repositories.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
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
        PilotoModel pilotoModel = pilotoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        messageSource.getMessage("mensagem.not.found.id", new Object[] {"Piloto", id}, Locale.getDefault())
                ));

        PilotoMapper mapper = new PilotoMapper();

        PilotoDTO pilotoDTO = mapper.toDTO(pilotoModel);

        return pilotoDTO;
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
        PilotoModel pilotoModel = pilotoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        messageSource.getMessage("mensagem.not.found.id", new Object[] {"Piloto", id}, Locale.getDefault())
                ));
        pilotoModel.setNome(cadastroPilotoDTO.getNome());
        pilotoModel.setNumeroLicenca(cadastroPilotoDTO.getNumeroLicenca());
        pilotoModel.setIdade(cadastroPilotoDTO.getIdade());
        pilotoModel.setAnoExperiencia(cadastroPilotoDTO.getAnoExperiencia());

        PilotoModel pilotoAtualizado = pilotoRepository.save(pilotoModel);
        return new PilotoDTO(pilotoAtualizado);
    }


    public void deletar(Long id) {
        PilotoModel pilotoModel = pilotoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        messageSource.getMessage("mensagem.not.found.id", new Object[] {"Piloto", id}, Locale.getDefault())
                ));

        if (!pilotoModel.getAgendas().isEmpty()) {
            throw new DataIntegrityViolationException(
                    messageSource.getMessage("mensagem.not.delete", new Object[] {"Piloto", "Agenda"}, Locale.getDefault()));
        }

        pilotoRepository.delete(pilotoModel);
    }



}