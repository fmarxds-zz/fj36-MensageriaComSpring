package br.com.felipe.publicador.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    private String nome;
    private String categoria;
    private Integer cargaHoraria;

}
