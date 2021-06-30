package br.com.zup.academy.mauricio.casadocodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorDto {

	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String nome;
	@Size(max = 400)
	private String descricao;
	
	

	public AutorDto(String email, String nome, String descricao) {
		super();
		this.email = email;
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	
	
}
