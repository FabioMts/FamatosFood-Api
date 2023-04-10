package com.Fabio.FamatosFoodapi.api.controller;

import com.Fabio.FamatosFoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.Fabio.FamatosFoodapi.domain.model.Cidade;
import com.Fabio.FamatosFoodapi.domain.model.Restaurante;
import com.Fabio.FamatosFoodapi.domain.repository.CidadeRepository;
import com.Fabio.FamatosFoodapi.domain.service.CadastroCidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {


    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    CadastroCidadeService cidadeService;

    @GetMapping
    public List<Cidade> listar() {
       return cidadeRepository.todas();
    }

    @GetMapping("/{cidadeId}")
    public ResponseEntity<Cidade> listaPorID(@PathVariable Long cidadeId) {
        Cidade cidade = cidadeRepository.porId(cidadeId);

        if(cidade != null) {
            return ResponseEntity.ok().body(cidade);
        }
        return  ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Cidade cidade) {
        try {
            cidade = cidadeService.salvar(cidade);
            return ResponseEntity.status(HttpStatus.CREATED).body(cidade);
        }catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{cidadeId}")
    public ResponseEntity<?> atualizar(@PathVariable Long cidadeId,
                                       @RequestBody Cidade cidade) {

        Cidade cidadeAtual = cidadeRepository.porId(cidadeId);

        try {
            if (cidadeAtual != null) {
                BeanUtils.copyProperties(cidade, cidadeAtual, "id");

                cidadeAtual = cidadeService.salvar(cidadeAtual);
                return ResponseEntity.ok(cidadeAtual);
            }
            return ResponseEntity.notFound().build();
        }catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
