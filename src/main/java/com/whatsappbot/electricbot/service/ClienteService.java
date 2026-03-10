package com.whatsappbot.electricbot.service;

import org.springframework.stereotype.Service;
import com.whatsappbot.electricbot.model.Cliente;
import com.whatsappbot.electricbot.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente guardarConsulta(String telefono, String mensaje){

        Cliente cliente = new Cliente();
        cliente.setTelefono(telefono);
        cliente.setMensaje(mensaje);

        return clienteRepository.save(cliente);
    }

}