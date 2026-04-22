package com.guijas1.ItauTech.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.OffsetDateTime;
import java.time.ZoneId;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {

    private double valor;
    private OffsetDateTime dataHora = OffsetDateTime.now(ZoneId.systemDefault());


}