package com.guijas1.ItauTech.dto;

import java.time.OffsetDateTime;

public record TransacaoDTO(
        Double valor,
        OffsetDateTime dataHora
) {

}