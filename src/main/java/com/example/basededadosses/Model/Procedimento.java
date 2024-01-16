package com.example.basededadosses.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table
@NoArgsConstructor
class Procedimento {

    @Id
    private Long codigo;
    private String titulo;
    private String resumo;
    private String descricao;
    private String imgUrl;

}
