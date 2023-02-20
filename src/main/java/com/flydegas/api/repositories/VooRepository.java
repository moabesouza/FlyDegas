package com.flydegas.api.repositories;

import com.flydegas.api.model.VooModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VooRepository extends JpaRepository <VooModel, Long> {
}
