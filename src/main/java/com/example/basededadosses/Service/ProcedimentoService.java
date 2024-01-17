package com.example.basededadosses.Service;

import com.example.basededadosses.Repository.ProcedimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;


@Service

public class ProcedimentoService {
    @Autowired
    private ProcedimentoRepository procedimentoRepository;

    public ResponseEntity<Void> excluirProcedimento(@PathVariable UUID codigo) {
        if (procedimentoRepository.existsById(codigo)) {
            procedimentoRepository.deleteById(codigo);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
