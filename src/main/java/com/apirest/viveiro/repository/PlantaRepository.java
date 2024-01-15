package com.apirest.viveiro.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apirest.viveiro.model.PlantaModel;

@Repository
public interface PlantaRepository extends CrudRepository<PlantaModel, Integer> {
	List<PlantaModel> findByTemFrutaTrue();
	List<PlantaModel> findByTemFrutaFalse();
	List<PlantaModel> findByQuantidadeLessThan(Integer quantidade);
	List<PlantaModel> findByTemFrutaTrueAndQuantidadeLessThan(Integer quantidade);
	List<PlantaModel> findByTemFrutaFalseAndQuantidadeLessThan(Integer quantidade);
}
