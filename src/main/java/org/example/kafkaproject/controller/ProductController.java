package org.example.kafkaproject.controller;


import org.example.kafkaproject.entites.Product;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/product")
public class ProductController {

    public ProductController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }
    private StreamBridge streamBridge;


    //par default kafka encode les messages sous format json, on peut bien les encoder comme l'on veut
    @GetMapping("/publish/{topic}")
    public Product publish(@PathVariable String topic){
        Product p1 = new Product("1","p1",12f,new Date());
        streamBridge.send(topic,p1);
        return p1;
    }
}