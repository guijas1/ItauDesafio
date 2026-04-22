package com.guijas1.ItauTech.dto;

public record ErrorResponse(
        int status,
        String message
) {
}
