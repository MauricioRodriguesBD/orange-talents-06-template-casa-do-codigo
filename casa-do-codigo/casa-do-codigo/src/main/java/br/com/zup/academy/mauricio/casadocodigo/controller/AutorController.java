package br.com.zup.academy.mauricio.casadocodigo.controller;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import br.com.zup.academy.mauricio.casadocodigo.model.Autor;
import br.com.zup.academy.mauricio.casadocodigo.repository.AutorRepository;
import br.com.zup.academy.mauricio.casadocodigo.request.NovoAutorRequest;


@RestController
@RequestMapping("/autor")
public class AutorController {

	
	
	@Autowired
	private AutorRepository repository;
	
	public AutorController(AutorRepository repository) {
		super();
		this.repository = repository;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Autor> getById(@PathVariable Integer id){
		Optional<Autor> autor = repository.findById(id);
		if(autor.isPresent()) {
			return ResponseEntity.ok(autor.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/criar")
	@Transactional
	public ResponseEntity<?> criar(@RequestBody @Valid NovoAutorRequest request){
		
//		Autor autor = new Autor(request.getNome(), request.getEmail(), request.getDescricao());
		Autor autor = request.toModel();
		repository.save(autor);
		
		return ResponseEntity.ok(autor);
	}
}
