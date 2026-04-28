package com.guijas1.ItauTech.controller;

import com.guijas1.ItauTech.configuration.EstatisticasConfiguration;
import com.guijas1.ItauTech.dto.EstatisticaDTO;
import com.guijas1.ItauTech.service.TransicaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class EstatisticaController {

    private final TransicaoService service;
    private final EstatisticasConfiguration config;

    @GetMapping
    public ResponseEntity<EstatisticaDTO> chekStats() {
        final var horaInicial = OffsetDateTime.now().minusSeconds(config.seconds());

        final var estatistica = service.estatistica(horaInicial);

        return ResponseEntity.ok(estatistica);
    }
}
