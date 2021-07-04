package br.com.zup.academy.mauricio.casadocodigo.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zup.academy.mauricio.casadocodigo.model.Pais;
import br.com.zup.academy.mauricio.casadocodigo.validation.UniqueValue;

public class NovoPaisRequest {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public NovoPaisRequest(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pais toModel() {

		return new Pais(this.nome);
	}

}
