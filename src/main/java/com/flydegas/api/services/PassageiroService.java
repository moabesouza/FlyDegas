package com.flydegas.api.services;

import com.flydegas.api.repositories.PassageiroRepository;
import org.springframework.stereotype.Service;

@Service
public class PassageiroService {

    final PassageiroRepository passageiroRepository;

    public PassageiroService(PassageiroRepository passageiroRepository) {
        this.passageiroRepository = passageiroRepository;
    }
}
