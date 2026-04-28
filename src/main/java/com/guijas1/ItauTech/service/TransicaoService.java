package com.guijas1.ItauTech.service;

import com.guijas1.ItauTech.dto.EstatisticaDTO;
import com.guijas1.ItauTech.dto.TransacaoDTO;
import com.guijas1.ItauTech.exeception.HttpException;
import com.guijas1.ItauTech.mapper.TransacaoMapper;
import com.guijas1.ItauTech.model.Transacao;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class TransicaoService {

    private final TransacaoMapper transacaoMapper;

    public TransicaoService(TransacaoMapper transacaoMapper) {
        this.transacaoMapper = transacaoMapper;
    }

    List<TransacaoDTO> dtoList = new LinkedList<>();

    public TransacaoDTO criarTransacao(TransacaoDTO dto) {
        validarTransacao(dto);
        Transacao transacao = transacaoMapper.toEntity(dto);
        dtoList.add(dto);
        return dto;
    }

    public void deletarTransacao(){
        dtoList.clear();
    }

    public List<TransacaoDTO> listarTransacoes(){
        return dtoList;
    }

    public EstatisticaDTO estatistica(OffsetDateTime horaInicial) {
        final var summary = dtoList.stream()
                .filter(t -> t.dataHora().isAfter(horaInicial) || t.dataHora().isEqual(horaInicial))
                .mapToDouble(t -> t.valor().doubleValue())
                .summaryStatistics();

        if (summary.getCount() == 0) {
            return new EstatisticaDTO(0, 0.0, 0.0, 0.0, 0.0);
        }

        return new EstatisticaDTO(
                summary.getCount(),
                summary.getSum(),
                summary.getAverage(),
                summary.getMin(),
                summary.getMax()
        );
    }

    private void validarTransacao(TransacaoDTO dto) {
        if (dto == null) {
            throw new HttpException("Body da requisição é obrigatório", HttpStatus.BAD_REQUEST);
        }

        if (dto.valor() == null) {
            throw new HttpException("Valor é obrigatório", HttpStatus.BAD_REQUEST);
        }

        if (dto.dataHora() == null) {
            throw new HttpException("Data é obrigatória", HttpStatus.BAD_REQUEST);
        }

        if (dto.valor() <= 0) {
            throw new HttpException("Valor deve ser maior que zero", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        if (dto.dataHora().isAfter(OffsetDateTime.now())) {
            throw new HttpException("Data futura não é permitida", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}