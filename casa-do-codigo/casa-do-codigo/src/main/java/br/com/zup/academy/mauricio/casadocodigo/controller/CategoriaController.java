package br.com.zup.academy.mauricio.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.academy.mauricio.casadocodigo.model.Categoria;
import br.com.zup.academy.mauricio.casadocodigo.repository.CategoriaRepository;
import br.com.zup.academy.mauricio.casadocodigo.request.NovaCategoriaRequest;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;

	public CategoriaController(CategoriaRepository repository) {
		super();
		this.repository = repository;
	}

	@PostMapping("/criar")
	@Transactional
	public ResponseEntity<?> criar(@Valid @RequestBody NovaCategoriaRequest request) {
		Categoria categoria = new Categoria(request.getNome());
		repository.save(categoria);
		return ResponseEntity.ok(categoria);

	}

}
