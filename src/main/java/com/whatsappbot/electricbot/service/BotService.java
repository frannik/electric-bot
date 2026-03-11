package com.whatsappbot.electricbot.service;

import org.springframework.stereotype.Service;

import com.whatsappbot.electricbot.model.Cliente;

@Service
public class BotService {

    private final ClienteService clienteService;

    public BotService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public String procesarMensaje(String telefono, String mensaje) {

        Cliente cliente = clienteService.buscarOCrearCliente(telefono);

        String estado = cliente.getEstado();
        String respuesta;

        switch (estado) {

            case "MENU":

                respuesta = """
                        Hola 👋 Soy el asistente eléctrico.

                        1️⃣ Instalación eléctrica
                        2️⃣ Reparación
                        3️⃣ Presupuesto
                        """;

                cliente.setEstado("ESPERANDO_OPCION");
                break;

            case "ESPERANDO_OPCION":

                if (mensaje.equals("1")) {
                    respuesta = "¿La instalación es domiciliaria o comercial?";
                    cliente.setEstado("TIPO_INSTALACION");
                } else {
                    respuesta = "No entendí la opción.";
                }

                break;

            default:

                respuesta = "No entendí el mensaje.";
        }

        clienteService.guardar(cliente);

        return respuesta;
    }
}