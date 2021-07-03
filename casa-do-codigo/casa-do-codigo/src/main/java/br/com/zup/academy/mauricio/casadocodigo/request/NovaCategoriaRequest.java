package br.com.zup.academy.mauricio.casadocodigo.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public class NovaCategoriaRequest {
	
	
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
