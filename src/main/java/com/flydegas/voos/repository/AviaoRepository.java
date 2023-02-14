package com.flydegas.voos.repository;


import com.flydegas.voos.model.AviaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;



public interface AviaoRepository extends JpaRepository<AviaoModel, Long> {

	ArrayList<AviaoModel> findByModelo(String modelo);

	ArrayList<AviaoModel> findByPrefixo(String prefixo);

	



}

