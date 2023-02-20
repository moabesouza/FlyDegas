package com.flydegas.api.dtos.mappers;

import com.flydegas.api.dtos.index.piloto.PilotoDTO;
import com.flydegas.api.model.PilotoModel;
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

