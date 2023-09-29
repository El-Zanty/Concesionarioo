package com.credibanco.conceseionario.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credibanco.conceseionario.app.entity.Vehicle;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {

}
