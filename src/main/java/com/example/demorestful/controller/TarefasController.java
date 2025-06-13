package com.example.demorestful.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demorestful.model.Tarefas;
import com.example.demorestful.repository.TarefasRepository;

@RestController
@RequestMapping({ "/tarefas" })
public class TarefasController {
	private TarefasRepository repository;

	TarefasController(TarefasRepository tarefasRepository) {
		this.repository = tarefasRepository;
	}

	@GetMapping
	public List<?> findAll() {
		return repository.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Tarefas create(@RequestBody Tarefas tarefas) {
		return repository.save(tarefas);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Tarefas tarefas) {
		return repository.findById(id).map(record -> {
			record.setNameTarefa(tarefas.getNameTarefa());
			record.setDataEntrega(tarefas.getDataEntrega());
			record.setResponsavelTarefa(tarefas.getResponsavelTarefa());
			Tarefas updated = repository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable long id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}