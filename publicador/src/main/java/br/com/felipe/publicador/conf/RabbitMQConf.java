package br.com.felipe.publicador.conf;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConf {

    @Autowired
    private ConnectionFactory connectionFactory;
    @Value("${publicador.rabbitmq.topic.aluno}")
    private String topicoAlunos;
    @Value("${publicador.rabbitmq.queue.aluno}")
    private String filaAlunos;

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public TopicExchange topicoAlunos() {
        return new TopicExchange(topicoAlunos);
    }

    @Bean
    public Queue filaAlunos() {
        return new Queue(filaAlunos);
    }

    @Bean
    public Binding ligaFilaAlunoComTopicoAluno(TopicExchange topicoAlunos, Queue filaAlunos) {
        return BindingBuilder
                .bind(filaAlunos)
                .to(topicoAlunos)
                .with("*");
    }

}
