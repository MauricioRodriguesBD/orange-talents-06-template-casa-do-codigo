package br.com.zup.academy.mauricio.casadocodigo.dto;

import java.math.BigDecimal;


import br.com.zup.academy.mauricio.casadocodigo.model.Livro;

public class DetalheLivroResponse {
	
	private DetalheAutorResponse autor;
	private String titulo;
	private String isbn;
	private int pagina;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	
	
	public DetalheLivroResponse(Livro livro){
		
		autor = new DetalheAutorResponse(livro.getAutor());
		titulo = livro.getTitulo();
		isbn = livro.getIsbn();
		pagina = livro.getPagina();
		preco = livro.getPreco();
		resumo = livro.getResumo();
		sumario = livro.getSumario();
	}


	public DetalheAutorResponse getAutor() {
		return autor;
	}


	public String getTitulo() {
		return titulo;
	}


	public String getIsbn() {
		return isbn;
	}


	public int getPagina() {
		return pagina;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public String getResumo() {
		return resumo;
	}


	public String getSumario() {
		return sumario;
	}
	
	
	
}
