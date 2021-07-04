package br.com.zup.academy.mauricio.casadocodigo.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.zup.academy.mauricio.casadocodigo.model.Autor;
import br.com.zup.academy.mauricio.casadocodigo.model.Categoria;
import br.com.zup.academy.mauricio.casadocodigo.model.Livro;
import br.com.zup.academy.mauricio.casadocodigo.validation.ExistsId;
import br.com.zup.academy.mauricio.casadocodigo.validation.UniqueValue;

public class NovoLivroRequest {
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
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

	
//	@ExistsId(domainClass = Categoria.class, fieldName = "id")
	private Integer idCategoria;
//	@ExistsId(domainClass = Autor.class, fieldName = "id")
	private Integer idAutor;

	public NovoLivroRequest(String titulo, String resumo, String sumario, BigDecimal preco, int pagina, String isbn,
			Integer idCategoria, Integer idAutor, @Future LocalDate data) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.pagina = pagina;
		this.isbn = isbn;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
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

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	

	public LocalDate getData() {
		return data;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public Integer getIdAutor() {
		return idAutor;
	}

	public Livro toModel(EntityManager manager) {

		@NotNull
		Autor autor = manager.find(Autor.class, idAutor);
		@NotNull
		Categoria categoria = manager.find(Categoria.class, idCategoria);

		Assert.state(autor != null, "Não é possível cadastrar pois o autor não se encontra no banco" + idAutor);
		Assert.state(categoria != null,
				"Não é possível cadastrar pois a categoria não se encontra no banco" + idCategoria);

		return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.pagina, this.isbn, categoria, autor,
				data);
	}

}
