package com.flydegas.api.repositories;

import com.flydegas.api.model.ViagemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViagemRepository extends JpaRepository <ViagemModel, Long> {
}
