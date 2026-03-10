package com.whatsappbot.electricbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whatsappbot.electricbot.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}