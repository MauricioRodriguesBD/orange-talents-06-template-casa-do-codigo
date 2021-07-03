package br.com.zup.academy.mauricio.casadocodigo.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zup.academy.mauricio.casadocodigo.model.Autor;
import br.com.zup.academy.mauricio.casadocodigo.model.Categoria;
import br.com.zup.academy.mauricio.casadocodigo.validation.UniqueValue;

public class NovaCategoriaRequest {
	
	@UniqueValue(domainClass = Categoria.class,fieldName = "nome" )
	@NotBlank
	private String nome;
	
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public NovaCategoriaRequest(String nome) {
		super();
		this.nome = nome;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

 
		
	
}
