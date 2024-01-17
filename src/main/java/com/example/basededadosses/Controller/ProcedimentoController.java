package com.example.basededadosses.Controller;

import com.example.basededadosses.Model.Procedimento;
import com.example.basededadosses.Repository.ProcedimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/procedimentos")
public class ProcedimentoController {

    @Autowired
    private ProcedimentoRepository procedimentoRepository;

    @GetMapping
    public List<Procedimento> listarProcedimentos() {
        return procedimentoRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Procedimento> obterProcedimento(@PathVariable UUID codigo) {
        return procedimentoRepository.findById(codigo)
                .map(procedimento -> new ResponseEntity<>(procedimento, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Void> criarProcedimento(@RequestBody Procedimento procedimento) {
        procedimentoRepository.save(procedimento);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Void> atualizarProcedimento(@PathVariable UUID codigo, @RequestBody Procedimento procedimento) {
        if (procedimentoRepository.existsById(codigo)) {
            procedimento.setCodigo(codigo);
            procedimentoRepository.save(procedimento);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> excluirProcedimento(@PathVariable UUID codigo) {
        if (procedimentoRepository.existsById(codigo)) {
            procedimentoRepository.deleteById(codigo);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}