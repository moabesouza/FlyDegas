package com.flydegas.voos.repository;

import com.flydegas.voos.model.VooModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VooRepository extends JpaRepository <VooModel, Long> {
}
