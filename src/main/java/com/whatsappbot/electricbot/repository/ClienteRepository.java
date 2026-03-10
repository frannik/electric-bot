package com.whatsappbot.electricbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.whatsappbot.electricbot.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByTelefono(String telefono);

}