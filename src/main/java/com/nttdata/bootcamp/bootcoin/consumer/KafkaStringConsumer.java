package com.nttdata.bootcamp.bootcoin.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaStringConsumer {

    Logger logger = LoggerFactory.getLogger(KafkaStringConsumer.class);

    /*@KafkaListener(topics = "topicobootcamp" , groupId = "group_id")
    public void consume(Double message) {
        logger.info("Obteniendo tipo de cambio {}", message);
    }*/

}
