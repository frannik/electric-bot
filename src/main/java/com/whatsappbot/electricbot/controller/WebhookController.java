package com.whatsappbot.electricbot.controller;

import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsappbot.electricbot.service.BotService;
import com.whatsappbot.electricbot.service.ClienteService;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    private final ClienteService clienteService;
    private final BotService botService;

    public WebhookController(ClienteService clienteService, BotService botService) {
        this.clienteService = clienteService;
        this.botService = botService;
    }

    @GetMapping
    public String verifyWebhook(
            @RequestParam(name = "hub.challenge", required = false) String challenge) {

        return challenge;
    }

   @PostMapping
public String receiveMessage(@RequestBody String payload) {

    try {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(payload);

        String telefono = root
                .path("entry").get(0)
                .path("changes").get(0)
                .path("value")
                .path("messages").get(0)
                .path("from")
                .asText();

        String mensaje = root
                .path("entry").get(0)
                .path("changes").get(0)
                .path("value")
                .path("messages").get(0)
                .path("text")
                .path("body")
                .asText();

        System.out.println("Telefono: " + telefono);
        System.out.println("Mensaje: " + mensaje);

        clienteService.guardarConsulta(telefono, mensaje);

        String respuesta = botService.generarRespuesta(mensaje);

        System.out.println("Respuesta del bot:");
        System.out.println(respuesta);

    } catch (Exception e) {
        System.out.println("Error procesando mensaje");
        e.printStackTrace();
    }

    return "EVENT_RECEIVED";
    }
}