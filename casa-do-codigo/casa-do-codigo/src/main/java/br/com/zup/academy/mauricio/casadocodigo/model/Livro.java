package br.com.zup.academy.mauricio.casadocodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonFormat.Shape;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String titulo;

	@NotBlank
	private String resumo;

	@NotBlank
	private String sumario;

	@NotNull
	@Min(20)
	private BigDecimal preco;

	@NotNull
	@Min(100)
	private int pagina;

	private String isbn;
	

	@Future
	private LocalDate data;

	@ManyToOne
	private Categoria categoria;
	@ManyToOne
	private Autor autor;

	@Deprecated
	private Livro() {
	}

	public Livro(String titulo, String resumo, String sumario, BigDecimal preco, int pagina, String isbn,
			Categoria categoria, Autor autor, @Future LocalDate data) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.pagina = pagina;
		this.isbn = isbn;
		this.categoria = categoria;
		this.autor = autor;
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getPagina() {
		return pagina;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public Long getId() {
		return id;
	}
	
	

}
