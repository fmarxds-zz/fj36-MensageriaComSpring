package br.com.felipe.publicador.api.controllers;

import br.com.felipe.publicador.domain.Aluno;
import br.com.felipe.publicador.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> listaAlunos() {
        return alunoService.buscaTodos();
    }

    @PostMapping
    public ResponseEntity<Aluno> criaAluno(@RequestBody Aluno aluno) throws URISyntaxException {
        Aluno al = alunoService.criaAluno(aluno);

        ResponseEntity.BodyBuilder created = ResponseEntity.created(new URI("alunos/" + aluno.getId()));

        return Optional.ofNullable(al)
            .map(aluno2 -> created.body(aluno2))
            .orElse(ResponseEntity.badRequest().build());
    }

}
