package br.com.zup.academy.mauricio.casadocodigo.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.academy.mauricio.casadocodigo.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Integer> {

	Optional<Autor>findByEmail(String email);

}
