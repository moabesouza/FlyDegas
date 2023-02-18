package com.flydegas.voos.services;

import com.flydegas.voos.model.AviaoModel;
import com.flydegas.voos.model.PilotoModel;
import com.flydegas.voos.repository.AviaoRepository;
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
