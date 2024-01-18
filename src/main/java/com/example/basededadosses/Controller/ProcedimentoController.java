package com.example.basededadosses.Controller;

import com.example.basededadosses.Model.Procedimento;
import com.example.basededadosses.Service.ProcedimentoService;
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
    private ProcedimentoService procedimentoService;

    @GetMapping
    public List<Procedimento> listarProcedimentos() {
        return procedimentoService.listarProcedimentos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Procedimento> obterProcedimento(@PathVariable UUID codigo) {
        return procedimentoService.encontrarProcedimentoPorId(codigo);
    }

    @PostMapping
    public ResponseEntity<Void> criarProcedimento(@RequestBody Procedimento procedimento) {
        procedimentoService.criarProcedimento(procedimento);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Procedimento> atualizarProcedimento(@PathVariable UUID codigo, @RequestBody Procedimento procedimento) {
        if (procedimentoService.encontrarProcedimentoPorId(codigo) != null) {
            procedimentoService.criarProcedimento(procedimento);
            return new ResponseEntity<>(procedimento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{codigo}")
    public ResponseEntity<String> deletarProcedimento(@PathVariable UUID codigo) {
        procedimentoService.excluirProcedimento(codigo);
        return new ResponseEntity<>("procedimento deletado com sucesso!", HttpStatus.OK);
    }
}