package br.com.felipe.consumidor.domain;

import lombok.Data;

@Data
public class Aluno {

    private String id;
    private String nome;
    private String matricula;
    private Integer idade;
    private String apelido;
    private Curso curso;

}
