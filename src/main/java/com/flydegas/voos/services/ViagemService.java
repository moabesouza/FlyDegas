package com.flydegas.voos.services;

import com.flydegas.voos.repository.ViagemRepository;
import org.springframework.stereotype.Service;

@Service
public class ViagemService {

    final ViagemRepository viagemRepository;

    public ViagemService(ViagemRepository viagemRepository) {
        this.viagemRepository = viagemRepository;
    }
}
