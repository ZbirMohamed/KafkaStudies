package org.example.kafkaproject.service;

import org.example.kafkaproject.entites.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Supplier;



@Service
public class ProductService {

    //consumer c'est lui qui prend soind de la consomation des messages venantes des services distantes
    @Bean
    public Consumer<Product> productConsumer(){
        return (input)->{
            System.out.println("****************************");
            System.out.println(input.toString());
            System.out.println("****************************");
        };
    }

    //poller ou bien le supplier c'est lui qui prend soin de l'envoi des donnees successive par exemple un capteur
    @Bean
    public Supplier<Product> productSupplier(){
        return ()->new Product("1","p1",12f,new Date());
    }
}
