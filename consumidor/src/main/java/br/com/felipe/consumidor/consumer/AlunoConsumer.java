package br.com.felipe.consumidor.consumer;

import br.com.felipe.consumidor.domain.Aluno;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AlunoConsumer {

    @RabbitListener(queues = "FILA-aluno", containerFactory = "simpleRabbitListenerContainerFactory")
    public void leitorDeMensagens(Aluno aluno) {
        log.info("LENDO MENSAGEM: {}", aluno);
    }

}
