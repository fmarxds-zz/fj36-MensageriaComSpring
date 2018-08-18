package br.com.felipe.publicador.service;

import br.com.felipe.publicador.domain.Aluno;
import br.com.felipe.publicador.rabbitmq.NotificaRabbitMQ;
import br.com.felipe.publicador.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;
    @Autowired
    private NotificaRabbitMQ rabbitMQ;

    public Aluno criaAluno(Aluno aluno) {
        rabbitMQ.notificaAluno(aluno);
        return repository.save(aluno);
    }

    public Aluno atualizaAluno(Aluno aluno) {
        rabbitMQ.notificaAluno(aluno);
        return repository.save(aluno);
    }

    public Aluno buscaAlunoPeloId(String id) {
        return repository.findOne(id);
    }

    public void deletaAlunoPeloId(String id) {
        repository.delete(id);
    }

    public List<Aluno> buscaTodos() {
        return repository.findAll();
    }
}
