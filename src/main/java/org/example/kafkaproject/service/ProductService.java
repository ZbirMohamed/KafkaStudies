package org.example.kafkaproject.service;

import org.apache.tomcat.util.net.NioEndpoint;
import org.example.kafkaproject.entites.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.dsl.PollerSpec;
import org.springframework.integration.dsl.Pollers;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Supplier;


//puisque on a deux fonctionalite il faut alors les declares dans notre application.properties spring.cloud.function.definition={"f1"};{"f2"}
//noter bien que ce n'est pas pratique normalement dans les applications microservice ou serverless une seul fonction existe c'est a elle de prendre soin
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
    //noter bien que le suplier par defaut envoi des messages chaque seconde et il est bien possible de le regler
    //spring.cloud.stream.poller.fixed-delay=5000 (delay de 5seconde)

    @Bean
    public Supplier<Product> productSupplier(){
        return ()->new Product("1","p1",12f,new Date());
    }



}
