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

import br.com.zup.academy.mauricio.casadocodigo.model.Cliente;
import br.com.zup.academy.mauricio.casadocodigo.repository.ClienteRepository;
import br.com.zup.academy.mauricio.casadocodigo.request.NovoClienteRequest;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
		
		@Autowired
		private ClienteRepository repository;
		
		
		
		@PersistenceContext
		private EntityManager manager;
		
		@PostMapping("/criar")
		@Transactional
		public ResponseEntity<?>criar(@Valid @RequestBody NovoClienteRequest request){
		
		Cliente cliente = request.toModel(manager);
		
		repository.save(cliente);
		
		return ResponseEntity.ok(cliente);
		}
}
