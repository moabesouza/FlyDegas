package com.flydegas.voos.repository;

import com.flydegas.voos.model.AgendaModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<AgendaModel, Long> {
}
