package com.guijas1.ItauTech.configuration;

import com.guijas1.ItauTech.exeception.MinorSecondsExeception;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "estatistica")
public record EstatisticasConfiguration(Integer seconds) {
        //TODO: REALIZAR A VALIDAÇÃO PARA IMPOSSIBILITAR SEGUNDOS NEGATIVOS.

    @Override
    public Integer seconds() {
        if(seconds <= 0){
            throw new MinorSecondsExeception("Segundos menores ou iguais a 0 não podem ser utilizados");
        }
        return seconds;
    }
}
