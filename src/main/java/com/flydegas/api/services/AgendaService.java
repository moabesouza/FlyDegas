package com.flydegas.api.services;

import com.flydegas.api.repositories.AgendaRepository;
import org.springframework.stereotype.Service;

@Service
public class AgendaService {

    final AgendaRepository agendaRepository;

    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }
}
