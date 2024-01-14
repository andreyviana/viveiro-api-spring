package com.apirest.viveiro.repository;

import org.springframework.data.repository.CrudRepository;

import com.apirest.viveiro.model.PlantaModel;

public interface PlantaRepository extends CrudRepository<PlantaModel, Integer> {
	
}
