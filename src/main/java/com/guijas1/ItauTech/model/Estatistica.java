package com.guijas1.ItauTech.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Estatistica {

    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;
}
