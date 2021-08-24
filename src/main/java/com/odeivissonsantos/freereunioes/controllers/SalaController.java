package com.odeivissonsantos.freereunioes.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odeivissonsantos.freereunioes.exception.ResourceNotFoundException;
import com.odeivissonsantos.freereunioes.models.SalaModel;
import com.odeivissonsantos.freereunioes.repositorys.SalaRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/salas")
public class SalaController {
	
	private final SalaRepository repository;

	@GetMapping
	public ResponseEntity<List<SalaModel>> listarTodos() {
		return ResponseEntity.ok().body(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SalaModel> buscarPorId(@PathVariable Long id)  throws ResourceNotFoundException {
			SalaModel sala = repository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Sala não Encontrada::" + id));
			return ResponseEntity.ok().body(sala);
		}
	
	@PostMapping
	public SalaModel criar(@Valid @RequestBody SalaModel sala) {
		return repository.save(sala);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id,
											@Valid @RequestBody SalaModel salaAtualizada) {
		salaAtualizada.setId(id);
		repository.save(salaAtualizada);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deletar(@PathVariable Long id)
	throws ResourceNotFoundException{
		SalaModel sala = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Sala não encontrada com esse ID::" + id));
		repository.delete(sala);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado", Boolean.TRUE);
		return response;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
