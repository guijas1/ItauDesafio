package com.guijas1.ItauTech.controller;

import com.guijas1.ItauTech.dto.TransacaoDTO;
import com.guijas1.ItauTech.exeception.HttpException;
import com.guijas1.ItauTech.model.Transacao;
import com.guijas1.ItauTech.service.TransicaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransicaoService transicaoService;

    public TransacaoController (TransicaoService transicaoService){
        this.transicaoService = transicaoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<TransacaoDTO> criarTransacao(@RequestBody TransacaoDTO dto){
        transicaoService.criarTransacao(dto);
        return ResponseEntity.status(201).body(dto);
    }

}
