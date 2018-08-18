package br.com.felipe.publicador.rabbitmq;

import br.com.felipe.publicador.domain.Aluno;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificaRabbitMQ {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${publicador.rabbitmq.topic.aluno}")
    private String topicoAlunos;

    public void notificaAluno(Aluno aluno) {
        log.info("ENVIADO MENSAGEM PARA ALUNO: {} / CURSO: {}", aluno.getNome(), aluno.getCurso().getNome());
        rabbitTemplate.convertAndSend(topicoAlunos, "*", aluno);
    }

}
