package br.com.zup.academy.mauricio.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.academy.mauricio.casadocodigo.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Long> {

}
