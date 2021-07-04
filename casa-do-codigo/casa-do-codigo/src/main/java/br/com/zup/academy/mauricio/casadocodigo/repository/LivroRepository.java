package br.com.zup.academy.mauricio.casadocodigo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.academy.mauricio.casadocodigo.model.Livro;
import br.com.zup.academy.mauricio.casadocodigo.response.LivroResponse;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Long> {

		
}
