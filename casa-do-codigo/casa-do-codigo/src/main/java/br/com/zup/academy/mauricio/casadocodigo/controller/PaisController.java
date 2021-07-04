package br.com.zup.academy.mauricio.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.academy.mauricio.casadocodigo.model.Pais;
import br.com.zup.academy.mauricio.casadocodigo.repository.PaisRepository;
import br.com.zup.academy.mauricio.casadocodigo.request.NovoPaisRequest;

@RestController
@RequestMapping("/pais")
public class PaisController {

	@Autowired
	private PaisRepository repository;

	@PostMapping("/criar")
	@Transactional
	public ResponseEntity<?> criar(@Valid @RequestBody NovoPaisRequest request) {
		Pais pais = request.toModel();
		repository.save(pais);
		return ResponseEntity.ok(pais);
	}

}
