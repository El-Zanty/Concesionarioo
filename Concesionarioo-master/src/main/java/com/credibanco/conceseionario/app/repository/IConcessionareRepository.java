package com.credibanco.conceseionario.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credibanco.conceseionario.app.entity.Concessionare;

public interface IConcessionareRepository extends JpaRepository<Concessionare, Integer> {

}
