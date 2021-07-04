package br.com.zup.academy.mauricio.casadocodigo.request;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;


import br.com.zup.academy.mauricio.casadocodigo.model.Estado;
import br.com.zup.academy.mauricio.casadocodigo.model.Pais;
import br.com.zup.academy.mauricio.casadocodigo.validation.UniqueValue;

public class NovoEstadoRequest {

	@NotBlank
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;
	
	@NotNull
	private Long idPais;
	
	

	public NovoEstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}

	public String getNome() {
		return nome;
	}

	public Estado toModel(EntityManager manager) {

		@NotNull
		Pais pais = manager.find(Pais.class, idPais);
		Assert.state(pais != null, "Não é possivel cadastrar pois o País" + idPais + "Não se encontra no Banco!");

		return new Estado(this.nome, pais);
	}

}
