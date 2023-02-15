package com.flydegas.voos.repository;

import com.flydegas.voos.model.ViagemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViagemRepository extends JpaRepository <ViagemModel, Long> {
}
