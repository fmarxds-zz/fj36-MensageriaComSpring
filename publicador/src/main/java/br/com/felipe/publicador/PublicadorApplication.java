package br.com.felipe.publicador;

import br.com.felipe.publicador.domain.Aluno;
import br.com.felipe.publicador.domain.Curso;
import br.com.felipe.publicador.rabbitmq.NotificaRabbitMQ;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@Slf4j
@SpringBootApplication
public class PublicadorApplication {

	@Autowired private NotificaRabbitMQ rabbitMQ;

	public static void main(String[] args) {
		SpringApplication.run(PublicadorApplication.class, args);
	}

	@PostConstruct
	public void diaDaMaldade() {
		Integer contador = 0;
        Curso curso = new Curso("36", "java", 40);
        Aluno aluno = new Aluno("123", "Felipe", "123456", 22, "fmarx", curso);
        while (contador <= 546000) {
            log.info("ENVIANDO MENSAGEM -> ALUNO: {}  CURSO {}", aluno.getNome(), aluno.getCurso().getNome());
            rabbitMQ.notificaAluno(aluno);
        }
	}
}
