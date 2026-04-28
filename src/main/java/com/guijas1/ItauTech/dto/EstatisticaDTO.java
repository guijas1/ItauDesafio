package com.guijas1.ItauTech.dto;


public record EstatisticaDTO(
        long count,
        Double sum,
        Double avg,
        Double min,
        Double max
) {
}
