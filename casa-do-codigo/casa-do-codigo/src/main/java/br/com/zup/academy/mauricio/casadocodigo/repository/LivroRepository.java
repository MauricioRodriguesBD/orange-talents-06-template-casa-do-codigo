package br.com.zup.academy.mauricio.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.academy.mauricio.casadocodigo.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Long> {

}