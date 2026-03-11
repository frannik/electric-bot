package com.whatsappbot.electricbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.whatsappbot.electricbot.model.Cliente;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByTelefono(String telefono);

}