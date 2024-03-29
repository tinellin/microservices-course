package com.microservices.course.store.car.message;

import com.microservices.course.store.car.dto.CarPostDTO;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka /* essencial para informar que essa classe será ouvinte do Kafka */
public class KafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    /* Método de conexão com o Kafka e outras configurações pelo lado do Consumer */
    @Bean
    public ConsumerFactory<String, CarPostDTO> consumerFactory() {

        Map<String, Object> props = new HashMap<>();

        /* Devemos informar onde o Kafka está rodando */
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

        /* Definimos o grupo de consumidores desse microsserviço */
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "store-posts-group");
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");

        /* Devemos realizar a deserealização do cjto. chave-valor */
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                new JsonDeserializer<>(CarPostDTO.class, false)
        );
    }

    /* Configurando o listener */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, CarPostDTO> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, CarPostDTO> factory =
                new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(this.consumerFactory());

        return factory;
    }

}
