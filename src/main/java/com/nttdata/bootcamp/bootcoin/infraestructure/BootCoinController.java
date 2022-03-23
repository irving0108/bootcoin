package com.nttdata.bootcamp.bootcoin.infraestructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.bootcoin.producer.KafkaStringProducer;

@RestController
@RequestMapping(value = "/bootcoin")
public class BootCoinController {

    private final KafkaStringProducer kafkaStringProducer;

    @Autowired
    BootCoinController(KafkaStringProducer kafkaStringProducer) {
        this.kafkaStringProducer = kafkaStringProducer;
    }

    @PostMapping(value = "/tc")
    public void sendMessageToKafkaTopic(@RequestParam("buy") String compra, @RequestParam("sale") String venta,
    		@RequestParam("date") String date) {
    	String jsonTC = "{\"buy\":"+compra+",\"sale\":"+venta+",\"date\":\""+date+"\"}";
        this.kafkaStringProducer.sendMessage(jsonTC);
    }
}
