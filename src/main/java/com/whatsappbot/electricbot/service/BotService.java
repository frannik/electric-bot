package com.whatsappbot.electricbot.service;

import org.springframework.stereotype.Service;

@Service
public class BotService {

    public String generarRespuesta(String mensaje) {

        mensaje = mensaje.toLowerCase();

        if(mensaje.contains("hola")) {
            return "Hola 👋 gracias por contactarte con ElectricBot.\n¿En qué podemos ayudarte?\n\n1️⃣ Instalación eléctrica\n2️⃣ Reparación\n3️⃣ Presupuesto";
        }

        if(mensaje.contains("instalacion")) {
            return "Perfecto. ¿Es una instalación eléctrica domiciliaria, comercial o industrial?";
        }

        if(mensaje.contains("reparacion")) {
            return "Contanos qué problema eléctrico estás teniendo.";
        }

        if(mensaje.contains("presupuesto")) {
            return "Para poder darte un presupuesto necesitamos algunos datos.\n¿Podés contarnos qué trabajo necesitás?";
        }

        return "Gracias por tu mensaje. En breve un electricista se pondrá en contacto.";
    }
}
