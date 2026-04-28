package com.guijas1.ItauTech.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "estatistica")
public record EstatisticasConfiguration(Integer seconds) {

}
