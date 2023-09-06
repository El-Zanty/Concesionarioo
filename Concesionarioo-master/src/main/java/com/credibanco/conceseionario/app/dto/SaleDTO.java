package com.credibanco.conceseionario.app.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
@Data
public class SaleDTO {
    //Lower = Inferior, Rate = Tarifa Until = Hasta
    // Vehicle Value Limits
    public static final double LOWER_LIMIT = 49470000.0; // Until $49,470,000
    public static final double LOWER_INTERMEDIATE = 111305000.0; // More of $49,470,000 and until $111,305,000

    // tax rates = tarifas de impuestos. Se aplica  impuesto Dependiendo de cuanto valga el automovil se aplica un diferente impuesto (IVA) u otro.
    public static final double LOWER_RATE = 0.015; // 1.5%
    public static final double INTERMEDIATE_RATE = 0.025; // 2.5%
    public static final double SUPERIOR_RATE = 0.035; // 3.5%

    private int id;
    private LocalDateTime date;      // Guarda fecha y hora de zona horaria local 
    private String paymentMethod;	 // Metodo de pago
    private BigDecimal totalSale;				
    private String nameClient;
    private String lastNameClient;
    private String nameEmployee;
    private String lastNameEmployee;
    private BigDecimal carBasePrice;      // Precio Base Vehiculo 





}
