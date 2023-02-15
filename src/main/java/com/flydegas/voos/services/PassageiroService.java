package com.flydegas.voos.services;

import com.flydegas.voos.repository.PassageiroRepository;
import org.springframework.stereotype.Service;

@Service
public class PassageiroService {

    final PassageiroRepository passageiroRepository;

    public PassageiroService(PassageiroRepository passageiroRepository) {
        this.passageiroRepository = passageiroRepository;
    }
}
