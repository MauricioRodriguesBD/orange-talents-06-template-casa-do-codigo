package br.com.zup.academy.mauricio.casadocodigo.controller;

import java.util.Optional;

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

import br.com.zup.academy.mauricio.casadocodigo.dto.AutorDto;
import br.com.zup.academy.mauricio.casadocodigo.model.Autor;
import br.com.zup.academy.mauricio.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/teste")
public class AutorController {

	
	@Autowired
	private AutorRepository repository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Autor> getById(@PathVariable Integer id){
		Optional<Autor> autor = repository.findById(id);
		if(autor.isPresent()) {
			return ResponseEntity.ok(autor.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/postar")
	@Transactional
	public ResponseEntity<Autor> post(@Valid @RequestBody Autor autor){
		Autor a = new Autor(autor.getEmail(),autor.getNome(),autor.getDescricao());
	
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(a));
		
	}
}
