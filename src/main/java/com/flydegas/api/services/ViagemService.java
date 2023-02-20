package com.flydegas.api.services;

import com.flydegas.api.repositories.ViagemRepository;
import org.springframework.stereotype.Service;

@Service
public class ViagemService {

    final ViagemRepository viagemRepository;

    public ViagemService(ViagemRepository viagemRepository) {
        this.viagemRepository = viagemRepository;
    }
}
