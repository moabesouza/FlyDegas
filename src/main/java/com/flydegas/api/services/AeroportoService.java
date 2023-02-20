package com.flydegas.api.services;

import com.flydegas.api.repositories.AeroportoRepository;
import org.springframework.stereotype.Service;

@Service
public class AeroportoService {

    final AeroportoRepository aeroportoRepository;

    public AeroportoService(AeroportoRepository aeroportoRepository) {
        this.aeroportoRepository = aeroportoRepository;
    }
}
