package com.flydegas.voos.services;

import com.flydegas.voos.repository.PilototoRepository;
import org.springframework.stereotype.Service;

@Service
public class PilotoService {

    final PilototoRepository pilototoRepository;

    public PilotoService(PilototoRepository pilototoRepository) {
        this.pilototoRepository = pilototoRepository;
    }
}
