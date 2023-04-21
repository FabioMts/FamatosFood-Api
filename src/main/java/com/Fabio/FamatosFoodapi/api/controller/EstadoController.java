package com.Fabio.FamatosFoodapi.api.controller;

import com.Fabio.FamatosFoodapi.domain.exception.EntidadeEmUsoException;
import com.Fabio.FamatosFoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.Fabio.FamatosFoodapi.domain.model.Cozinha;
import com.Fabio.FamatosFoodapi.domain.model.Estado;
import com.Fabio.FamatosFoodapi.domain.repository.CozinhaRepository;
import com.Fabio.FamatosFoodapi.domain.repository.EstadoRepository;
import com.Fabio.FamatosFoodapi.domain.service.CadastroEstadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CadastroEstadoService estadoService;

    @GetMapping
    public List<Estado> listar() {
        return estadoRepository.findAll();
    }


    @GetMapping("/{estadoId}")
    public ResponseEntity<Estado> buscar(@PathVariable Long estadoId) {
        Optional<Estado> estado =  estadoRepository.findById(estadoId);

        if(estado.isPresent()) {
            return ResponseEntity.ok(estado.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estado salvar(@RequestBody Estado estado) {
        return estado = estadoRepository.save(estado);
    }

    @DeleteMapping("/{estadoId}")
    public ResponseEntity<?> remover(@PathVariable Long estadoId) {
        try {
            estadoService.excluir(estadoId);
            return ResponseEntity.noContent().build();
        }catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PutMapping("/{estadoId}")
    public ResponseEntity<?> atualizar(@PathVariable Long estadoId,
                                             @RequestBody Estado estado) {
        Optional<Estado> estadoAtual = estadoRepository.findById(estadoId);

        if (estadoAtual.isPresent()) {
            BeanUtils.copyProperties(estado, estadoAtual, "id");

            Estado estadoSalvo = estadoService.salvar(estadoAtual.get());
            return ResponseEntity.ok(estadoAtual);
        }
        return ResponseEntity.notFound().build();
    }

}
