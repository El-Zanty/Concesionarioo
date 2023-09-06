package com.credibanco.conceseionario.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
@Table(name = "sales")
@Data
// Esta clase abarca el comportamiento de una factura 
public class Sale {

    public static final double LOWER_LIMIT = 49470000.0;                      //Limiete Inferior del valor del vheiculo  
    public static final double LOWER_INTERMEDIATE = 111305000.0;			  //Limiete Intermedio del valor del vheiculo 	

    public static final double LOWER_RATE = 0.015;							  //Si el valor es <= al limite inferior se aplica la tarifa inferior al valor neto del vheiculo   
    public static final double INTERMEDIATE_RATE = 0.025;					  //Si el valor es <= al limite intermedio se aplica la tarifa intermedia al valor neto del vheiculo 
    public static final double SUPERIOR_RATE = 0.035;	                      //Si el valor es > al limite intermedio se aplica la tarifa superior al valor neto del vheiculo 	
    
    //instancia de DateTimeFormatter
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

          
    @Column(name = "dates")
    private LocalDateTime date;              // Se almacena tanto fecha como hora
    
                                   
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]*$")
    @Column(name = "payments_methods")      // Metodos de pago
    private String paymentMethod;
    
    @NotNull                                
    @Column(name = "total_sales")           // Venta total
    private double totalSale;
    
                                   
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]*$")
    @Column(name = "names_clients")
    private  String nameClient;
    
                                  
    @Pattern(regexp = "^[a-zA-Z]*$")
    @Column(name = "last_names_clients")
    private String lastNameClient;
    
                                 
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]*$")
    @Column(name = "names_employees")
    private String nameEmployee;
    
                                   
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]*$")
    @Column (name = "last_names_employees")
    private String lastNameEmployee;
    
    
    @Column (name = "car_base_prices")      // Precio base automovil
    private double carBasePrice;
    
    @NotNull                                // No puede venir vacio osea sin valor 
    @NotBlank								// que no sea una cadena de longitud cero o que solo contenga espacios en blanco						
    @Pattern(regexp = "^[a-zA-Z]*$")
    @Column (name = "name_concessionare")
    private  String branchname;             //nombre de sucursal
    
    
    @ManyToOne
    @JoinColumn(name = "idClient")          // Nombre que mantiene la relacion con de la tabla Sale con client
    Client idClient;

    @ManyToOne
    @JoinColumn(name = "idConcessionare")	
    Concessionare idConcessionare;
    
    @ManyToOne
    @JoinColumn(name = "idEmployee")
    Employee idEmployee;
    
    @OneToOne
    @JoinColumn(name = "idVehicle")
    Vehicle idVehicle;




}
