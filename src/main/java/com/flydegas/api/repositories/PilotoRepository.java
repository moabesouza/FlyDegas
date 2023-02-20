package com.flydegas.api.repositories;

import com.flydegas.api.model.PilotoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PilotoRepository extends JpaRepository<PilotoModel,Long> {
    Optional<PilotoModel> findByNumeroLicenca(String numeroLicenca);
}
