package com.example.basededadosses.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table
@NoArgsConstructor
public class Procedimento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID codigo;
    private String titulo;
    private String resumo;
    private String descricao;
    private String urlDaImagem;

}
