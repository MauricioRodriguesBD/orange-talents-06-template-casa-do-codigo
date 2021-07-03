package br.com.zup.academy.mauricio.casadocodigo.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.zup.academy.mauricio.casadocodigo.model.Autor;
import br.com.zup.academy.mauricio.casadocodigo.model.Categoria;
import br.com.zup.academy.mauricio.casadocodigo.validation.UniqueValue;

public class NovoAutorRequest {

	private String nome;
	
	@NotBlank
	@Email
	@UniqueValue(domainClass = Autor.class,fieldName = "email" )
	private String email;
	
	@NotBlank
	private String descricao;



	public NovoAutorRequest(String nome, @NotBlank @Email String email, @NotBlank String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Autor toModel() {
		 
		return new Autor(this.nome, this.email, this.descricao);
	}
}
