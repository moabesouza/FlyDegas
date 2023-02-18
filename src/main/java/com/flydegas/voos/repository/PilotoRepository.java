package com.flydegas.voos.repository;

import com.flydegas.voos.model.PilotoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PilotoRepository extends JpaRepository<PilotoModel,Long> {
    Optional<PilotoModel> findByNumeroLicenca(String numeroLicenca);
}
