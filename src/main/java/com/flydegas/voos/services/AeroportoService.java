package com.flydegas.voos.services;

import com.flydegas.voos.repository.AeroportoRepository;
import org.springframework.stereotype.Service;

@Service
public class AeroportoService {

    final AeroportoRepository aeroportoRepository;

    public AeroportoService(AeroportoRepository aeroportoRepository) {
        this.aeroportoRepository = aeroportoRepository;
    }
}
