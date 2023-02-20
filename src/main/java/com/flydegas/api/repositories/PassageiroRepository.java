package com.flydegas.api.repositories;


import com.flydegas.api.model.PassageiroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassageiroRepository extends JpaRepository<PassageiroModel, Long> {
}
