package com.flydegas.voos.services;

import com.flydegas.voos.repository.VooRepository;

import org.springframework.stereotype.Service;

@Service
public class VooService {


    final VooRepository vooRepository;

    public VooService(VooRepository vooRepository) {
        this.vooRepository = vooRepository;
    }
}
