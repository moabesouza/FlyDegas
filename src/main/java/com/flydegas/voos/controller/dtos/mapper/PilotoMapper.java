package com.flydegas.voos.controller.dtos.mapper;

import com.flydegas.voos.controller.dtos.index.piloto.PilotoDTO;
import com.flydegas.voos.model.PilotoModel;
import org.springframework.stereotype.Component;

@Component
public class PilotoMapper {

    public PilotoDTO toDTO(PilotoModel piloto) {
        PilotoDTO pilotoDTO = new PilotoDTO();
        pilotoDTO.setPiloto_id(piloto.getPiloto_id());
        pilotoDTO.setNome(piloto.getNome());
        pilotoDTO.setNumeroLicenca(piloto.getNumeroLicenca());
        pilotoDTO.setIdade(piloto.getIdade());
        pilotoDTO.setAnoExperiencia(piloto.getAnoExperiencia());
        return pilotoDTO;
    }

    public PilotoModel toModel(PilotoDTO pilotoDTO) {
        PilotoModel piloto = new PilotoModel();
        piloto.setPiloto_id(pilotoDTO.getPiloto_id());
        piloto.setNome(pilotoDTO.getNome());
        piloto.setNumeroLicenca(pilotoDTO.getNumeroLicenca());
        piloto.setIdade(pilotoDTO.getIdade());
        piloto.setAnoExperiencia(pilotoDTO.getAnoExperiencia());
        return piloto;
    }
}

