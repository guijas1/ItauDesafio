package com.guijas1.ItauTech.mapper;

import com.guijas1.ItauTech.dto.EstatisticaDTO;
import com.guijas1.ItauTech.dto.TransacaoDTO;
import com.guijas1.ItauTech.model.Estatistica;
import org.springframework.stereotype.Component;

@Component
public class EstatisticaMapper {

    public static Estatistica toEntity(EstatisticaDTO dto){
        return new Estatistica(
                dto.count(),
                dto.sum(),
                dto.avg(),
                dto.min(),
                dto.max()
        );
    }

    public static EstatisticaDTO toDTO(Estatistica estatistica){
        return new EstatisticaDTO(
                estatistica.getCount(),
                estatistica.getSum(),
                estatistica.getAvg(),
                estatistica.getMin(),
                estatistica.getMax()
        );
    }
}
