package com.whatsappbot.electricbot.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatsappbot.electricbot.model.Consulta;
import com.whatsappbot.electricbot.repository.ConsultaRepository;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta guardarConsulta(String telefono, String mensaje){

        Consulta c = new Consulta();
        c.setTelefono(telefono);
        c.setMensaje(mensaje);
        c.setFecha(LocalDateTime.now());
        c.setEstado("NUEVA");

        return consultaRepository.save(c);
    }

}
