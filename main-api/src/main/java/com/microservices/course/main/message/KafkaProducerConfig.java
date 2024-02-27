package com.microservices.course.main.message;

import com.microservices.course.main.dto.CarPostDTO;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;

    @Bean
    public ProducerFactory<String, CarPostDTO> userProducerFactory() {

        Map<String, Object> configProps = new HashMap<>();

        /* Devemos informa ao Kakfa em que porta ele irá subir o servidor interno */
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);

        /* Informa ao Kafka que não queremos nenhum cabeçalho na mensagem */
        configProps.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);

        /* Devemos informar ao Kafka qual é o formato de serialização da chave da mensagem */
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        /* Devemos informar ao Kafka qual é o formato de serialização do valor da mensagem */
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, CarPostDTO> userKafkaTemplate() {
        /* Para fazer uso do nossa configuração, devemos criar um template */
        return new KafkaTemplate<>(userProducerFactory());
    }
}
