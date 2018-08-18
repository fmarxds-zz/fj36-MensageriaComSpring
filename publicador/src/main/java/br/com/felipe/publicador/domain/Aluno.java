package br.com.felipe.publicador.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "alunos")
public class Aluno {

    @Id
    private String id;
    private String nome;
    private String matricula;
    private Integer idade;
    private String apelido;
    private Curso curso;

}
