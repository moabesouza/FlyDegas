package com.flydegas.api.repositories;

import com.flydegas.api.model.AgendaModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<AgendaModel, Long> {
}
