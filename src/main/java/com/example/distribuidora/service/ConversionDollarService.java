package com.example.distribuidora.service;

import com.example.distribuidora.entities.model.Precio;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
public class ConversionDollarService {

    /**
     *
     * @return el último resultado actualizado del valor del dólar
     */
    public ResponseEntity<?> obtenerPrecioDollar(){
        String apiUrl = "https://www.datos.gov.co/resource/32sa-8pi3.json";

        WebClient client = WebClient.create();

        Mono<ResponseEntity<String>> responseMono = client.get()
                .uri(apiUrl)
                .retrieve()
                .toEntity(String.class);

        // se bloquea el hilo para que se procese la solicitud a la api externa
        ResponseEntity<String> responseEntity = responseMono.block();

        if (responseEntity != null && responseEntity.getBody() != null) {
            String json = responseEntity.getBody();

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                    .create();

            List<Precio> lista = gson.fromJson(json, new TypeToken<List<Precio>>(){}.getType());
            return ResponseEntity.ok().body(lista.get(0));
        } else {
           return ResponseEntity.badRequest().body("No se pudo procesar la solicitud, contacte con soporte.");
        }
    }

}
