package com.flydegas.api.services;

import com.flydegas.api.repositories.VooRepository;

import org.springframework.stereotype.Service;

@Service
public class VooService {


    final VooRepository vooRepository;

    public VooService(VooRepository vooRepository) {
        this.vooRepository = vooRepository;
    }
}
