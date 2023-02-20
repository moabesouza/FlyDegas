package com.flydegas.api.repositories;


import com.flydegas.api.model.AeroportoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AeroportoRepository extends JpaRepository<AeroportoModel, Long> {
}
