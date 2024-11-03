package com.kamirru.config.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kamirru.config.repository.MerchantConfigRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
@Log4j2
public class MerchantConfigController {

    private final MerchantConfigRepository merchantConfigRepository;
    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/publish")
    public String saveMerchantConfig(@RequestBody MerchantConfigRequest merchantConfigRequest) {
        rabbitTemplate.convertAndSend("config-exchange", "config_routing_key", merchantConfigRequest);
        return "success";
    }

    @RabbitHandler
    @RabbitListener(queues = "config-queue")
    public void readMessage(Message message) throws JsonProcessingException {
        log.info("Reading message from RabbitMq broker");
        String json = new String(message.getBody());
        ObjectMapper objectMapper = new ObjectMapper();
        MerchantConfigRequest merchantConfigRequest = objectMapper.readValue(json, MerchantConfigRequest.class);
        merchantConfigRepository.save(merchantConfigRequest);

    }

}
