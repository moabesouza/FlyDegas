package com.flydegas.voos.services;

import com.flydegas.voos.repository.AviaoRepository;
import org.springframework.stereotype.Service;

@Service
public class AviaoService {

    final AviaoRepository aviaoRepository;

    public AviaoService(AviaoRepository aviaoRepository) {
        this.aviaoRepository = aviaoRepository;
    }
}
