package com.credibanco.conceseionario.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "sales")
@Data
public class Sale {

    public static final double LOWER_LIMIT = 49470000.0;
    public static final double LOWER_INTERMEDIATE = 111305000.0;

    public static final double LOWER_RATE = 0.015;
    public static final double INTERMEDIATE_RATE = 0.025;
    public static final double SUPERIOR_RATE = 0.035;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)  // Se almacena tanto fecha como hora
    @Column(name = "dates")
    private Date date;

    @Column(name = "payments_methods") // Metodos de pago
    private String paymentMethod;

    @Column(name = "total_sales") // Venta total
    private double totalSale;

    @Column(name = "names_clients")
    private  String nameClient;

    @Column(name = "last_names_clients")
    private String lastNameClient;

    @Column(name = "names_employees")
    private String nameEmployee;

    @Column (name = "last_names_employees")
    private String lastNameEmployee;

    @Column (name = "car_base_prices") // Precio base automovil
    private double carBasePrice;

    @Column (name = "name_concessionare")
    private  String branchname;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client idClient;

    @ManyToOne
    @JoinColumn(name = "idConcessionare")
    Concessionare idConcessionare;





}
