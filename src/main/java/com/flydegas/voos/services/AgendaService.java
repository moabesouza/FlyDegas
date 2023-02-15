package com.flydegas.voos.services;

import com.flydegas.voos.repository.AgendaRepository;
import org.springframework.stereotype.Service;

@Service
public class AgendaService {

    final AgendaRepository agendaRepository;

    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }
}
