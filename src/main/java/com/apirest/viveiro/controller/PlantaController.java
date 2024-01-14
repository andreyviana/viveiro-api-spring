package com.apirest.viveiro.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.apirest.viveiro.model.PlantaModel;
import com.apirest.viveiro.repository.PlantaRepository;

@RestController
public class PlantaController {
	
	private final PlantaRepository plantaRepository;
	
	public PlantaController(final PlantaRepository plantaRepository) {
		this.plantaRepository = plantaRepository;
	}
	
	@GetMapping("/plantas")
	public Iterable<PlantaModel> getAllPlantas() {
		return plantaRepository.findAll();
	}
	
	@GetMapping("/plantas/{id}")
	public Optional<PlantaModel> getPlantaById(@PathVariable("id") Integer id) {
		return this.plantaRepository.findById(id);
	}
	
	@PostMapping("/plantas")
	public PlantaModel adicionarPlanta(@RequestBody PlantaModel p) {
		PlantaModel novaPlanta = this.plantaRepository.save(p);
		return novaPlanta;
	}

	@PutMapping("/plantas/{id}")
	public PlantaModel atualizarPlanta(@RequestBody PlantaModel p, @PathVariable("id") Integer id) {
		Optional<PlantaModel> plantaParaAtualizarOptional = getPlantaById(id);
		if (!plantaParaAtualizarOptional.isPresent()) {
			return null;
		}

		PlantaModel plantaParaAtualizar = plantaParaAtualizarOptional.get();
		
		if (p.getNome() != null) {
			plantaParaAtualizar.setNome(p.getNome());
		}
		
		if (p.getQuantidade() != null) {
			plantaParaAtualizar.setQuantidade(p.getQuantidade());
		}

		if (p.getFrequenciaRegagem() != null) {
			plantaParaAtualizar.setFrequenciaRegagem(p.getFrequenciaRegagem());
		}

		if (p.getTemFruta() != null) {
			plantaParaAtualizar.setFrequenciaRegagem(p.getFrequenciaRegagem());
		}

		PlantaModel plantaAtualizada = this.plantaRepository.save(plantaParaAtualizar);
		return plantaAtualizada;
	}
	
	@DeleteMapping("plantas/{id}")
	public PlantaModel deletarPlanta(@PathVariable("id") Integer id) {
		Optional<PlantaModel> plantaParaDeletarOptional = getPlantaById(id);
		if (!plantaParaDeletarOptional.isPresent()) {
			return null;			
		}

		PlantaModel plantaParaDeletar = plantaParaDeletarOptional.get();
		this.plantaRepository.delete(plantaParaDeletar);

		return plantaParaDeletar;
	}
}
