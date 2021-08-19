package com.odeivissonsantos.freereunioes.controllers;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.odeivissonsantos.freereunioes.exception.ResourceNotFoundException;
import com.odeivissonsantos.freereunioes.models.Convidado;
import com.odeivissonsantos.freereunioes.models.SalaModel;
import com.odeivissonsantos.freereunioes.repositorys.ConvidadoRepository;
import com.odeivissonsantos.freereunioes.repositorys.SalaRepository;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/convidados")
public class ConvidadoController {
	
	private final ConvidadoRepository repository;
	private final SalaRepository salaRepository;
	
	public ConvidadoController(ConvidadoRepository repository, SalaRepository salaRepository) {
		super();
		this.repository = repository;
		this.salaRepository = salaRepository;
	}

	@GetMapping
	public ResponseEntity<List<Convidado>> listarTodos() {
		return ResponseEntity.ok().body(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Convidado> buscarPorId(@PathVariable Integer id)  throws ResourceNotFoundException {
			Convidado convidado = repository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Convidado não Encontrado::" + id));
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(convidado.getId()).toUri();
			return ResponseEntity.created(uri).body(convidado);
		}
	
	@PostMapping
	public Convidado criar(@RequestBody Integer sala_id, Convidado convidado) {
		convidado.setId(null);
		SalaModel sala = salaRepository.findById(sala_id).get();
		convidado.setSala(sala);
		return repository.save(convidado);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer id,
											@Valid @RequestBody Convidado convidadoAtualizado) {
		convidadoAtualizado.setId(id);
		repository.save(convidadoAtualizado);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deletar(@PathVariable Integer id)
	throws ResourceNotFoundException{
		Convidado convidado = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Convidado não encontrada com esse ID::" + id));
		repository.delete(convidado);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado", Boolean.TRUE);
		return response;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
