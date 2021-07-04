package br.com.zup.academy.mauricio.casadocodigo.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.academy.mauricio.casadocodigo.model.Livro;
import br.com.zup.academy.mauricio.casadocodigo.repository.LivroRepository;
import br.com.zup.academy.mauricio.casadocodigo.request.NovoLivroRequest;
import br.com.zup.academy.mauricio.casadocodigo.response.LivroResponse;

@RestController
@RequestMapping("/livro")
public class LivroController {

	private LivroRepository repository;

	@PersistenceContext
	private EntityManager manager;

	public LivroController(LivroRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/buscar")
	public ResponseEntity <List<?>>buscarTodos(){
		List<Livro> livro = repository.findAll();
        return ResponseEntity.ok(livro.stream()
        		.map(LivroResponse::new)
        		.collect(Collectors.toList()));
	}

	@PostMapping("/criar")
	@Transactional
	public ResponseEntity<?> criar(@Valid @RequestBody NovoLivroRequest request) {

		Livro livro = request.toModel(manager);
	
		repository.save(livro);
		return ResponseEntity.ok(livro);
	}

}
