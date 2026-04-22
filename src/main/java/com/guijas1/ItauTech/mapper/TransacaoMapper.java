package com.guijas1.ItauTech.mapper;

import com.guijas1.ItauTech.dto.TransacaoDTO;
import com.guijas1.ItauTech.model.Transacao;
import org.springframework.stereotype.Component;

@Component
public class TransacaoMapper {

    public static Transacao toEntity(TransacaoDTO dto){
        return new Transacao(
                dto.valor(),
                dto.dataHora()
        );
    }

    public static TransacaoDTO toDTO(Transacao entity){
        return new TransacaoDTO(
                entity.getValor(),
                entity.getDataHora()
        );
    }
}
