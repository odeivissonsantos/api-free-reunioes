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
import com.odeivissonsantos.freereunioes.models.Convidado;
import com.odeivissonsantos.freereunioes.models.SalaModel;
import com.odeivissonsantos.freereunioes.repositorys.ConvidadoRepository;
import com.odeivissonsantos.freereunioes.repositorys.SalaRepository;

import lombok.RequiredArgsConstructor;


@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/convidados")
public class ConvidadoController {
	
	private final ConvidadoRepository repository;
	private final SalaRepository salaRepository;

	
	@GetMapping
	public ResponseEntity<List<Convidado>> listarTodos() {
		return ResponseEntity.ok().body(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Convidado> buscarPorId(@PathVariable Long id)  throws ResourceNotFoundException {
			Convidado convidado = repository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Convidado não Encontrado::" + id));
			return ResponseEntity.ok().body(convidado);
		}
	
	@PostMapping
	public ResponseEntity<Convidado> criar(@RequestBody Convidado convidado) {
		SalaModel sala = salaRepository.findById(convidado.getIdSala()).orElse(null);
		
			convidado.setSala(sala);
			return ResponseEntity.ok().body(repository.save(convidado));
		
	      
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Convidado> atualizar(@PathVariable Long id,
											@Valid @RequestBody Convidado convidadoAtualizado) {
		convidadoAtualizado.setId(id);
		return ResponseEntity.ok().body(repository.save(convidadoAtualizado));
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deletar(@PathVariable Long id)
	throws ResourceNotFoundException{
		Convidado convidado = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Convidado não encontrada com esse ID::" + id));
		repository.delete(convidado);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado", Boolean.TRUE);
		return response;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
