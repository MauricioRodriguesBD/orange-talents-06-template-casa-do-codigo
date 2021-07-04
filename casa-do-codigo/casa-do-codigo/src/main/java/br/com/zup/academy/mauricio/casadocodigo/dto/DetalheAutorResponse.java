package br.com.zup.academy.mauricio.casadocodigo.dto;

import br.com.zup.academy.mauricio.casadocodigo.model.Autor;

public class DetalheAutorResponse {

	private String nome;
	private String descricao;
	private String email;

	public DetalheAutorResponse(Autor autor) {
		nome = autor.getNome();
		descricao = autor.getDescricao();
		email = autor.getEmail();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getEmail() {
		return email;
	}
	
	
}
