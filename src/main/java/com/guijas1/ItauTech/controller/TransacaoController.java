package com.guijas1.ItauTech.controller;

import com.guijas1.ItauTech.dto.TransacaoDTO;
import com.guijas1.ItauTech.exeception.HttpException;
import com.guijas1.ItauTech.model.Transacao;
import com.guijas1.ItauTech.service.TransicaoService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransicaoService transicaoService;

    public TransacaoController (TransicaoService transicaoService){
        this.transicaoService = transicaoService;
    }

    @PostMapping()
    public ResponseEntity<TransacaoDTO> criarTransacao(@RequestBody TransacaoDTO dto){
        transicaoService.criarTransacao(dto);
        return ResponseEntity.status(201).body(dto);
    }
    @DeleteMapping()
    public ResponseEntity deletarTransacao(){
        transicaoService.deletarTransacao();
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<TransacaoDTO>> listarTodas(){
        List<TransacaoDTO> transacaoDTOS = transicaoService.listarTransacoes();
        return ResponseEntity.ok(transacaoDTOS);
    }

}
