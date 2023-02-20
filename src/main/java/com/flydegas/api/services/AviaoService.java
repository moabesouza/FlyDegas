package com.flydegas.api.services;

import com.flydegas.api.model.AviaoModel;
import com.flydegas.api.model.PilotoModel;
import com.flydegas.api.repositories.AviaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AviaoService {

    final AviaoRepository aviaoRepository;

    public AviaoService(AviaoRepository aviaoRepository) {
        this.aviaoRepository = aviaoRepository;
    }

    public List<PilotoModel> getPilotos(Long aviaoId) {
        AviaoModel aviao = aviaoRepository.findById(aviaoId).orElseThrow();
        return aviao.getPilotos();
    }
}
