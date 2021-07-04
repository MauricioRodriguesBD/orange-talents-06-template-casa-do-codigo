package br.com.zup.academy.mauricio.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.academy.mauricio.casadocodigo.model.Estado;
import br.com.zup.academy.mauricio.casadocodigo.repository.EstadoRepository;
import br.com.zup.academy.mauricio.casadocodigo.request.NovoEstadoRequest;

@RestController
@RequestMapping("/estado")
public class EstadoController {

	@Autowired
	private EstadoRepository repository;
	
	@PersistenceContext
	private EntityManager manager;

	@PostMapping("/criar")
	@Transactional
	public ResponseEntity<?> criar(@Valid @RequestBody NovoEstadoRequest request) {
		Estado estado = request.toModel(manager);
		repository.save(estado);
		return ResponseEntity.ok(estado);
	}

}
