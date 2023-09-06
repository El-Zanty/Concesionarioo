package com.credibanco.conceseionario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class}) // Comando que simula Base de Datos para iniciar el pryecto   
public class CrudConcesionarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudConcesionarioApplication.class, args);
	}

}
