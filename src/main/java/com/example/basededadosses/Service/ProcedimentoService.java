package com.example.basededadosses.Service;

import com.example.basededadosses.Model.Procedimento;
import com.example.basededadosses.Repository.ProcedimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service

public class ProcedimentoService {
    @Autowired
    private ProcedimentoRepository procedimentoRepository;

    public void excluirProcedimento(UUID codigo) {
        procedimentoRepository.deleteById(codigo);
    }

    public List<Procedimento> listarProcedimentos() {
        return procedimentoRepository.findAll();
    }

    public ResponseEntity<Procedimento> encontrarProcedimentoPorId(UUID codigo) {
        Procedimento procedimento = procedimentoRepository.findById(codigo).orElse(null);
        if (procedimento != null) {
            return new ResponseEntity<>(procedimento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public void criarProcedimento(Procedimento procedimento) {
        procedimentoRepository.save(procedimento);
    }
}
