package com.credibanco.conceseionario.app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "concessionares")
@Data
public class Concessionare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "names")
    private String nameConcessionare;

    @Column(name = "adress")
    private String address;

    @Column(name = "phones")
    private Long phone;
}
