package org.example.kafkaproject.entites;


import lombok.*;

import java.util.Date;

@Getter @Setter @ToString
public class Product {

    private String id;
    private String name;
    private Float price;
    private Date dateAchat;

    public Product(String id, String name,Float price,Date dateAchat) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dateAchat= dateAchat;
    }
}
