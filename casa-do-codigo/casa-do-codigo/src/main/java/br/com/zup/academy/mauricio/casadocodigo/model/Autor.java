package br.com.zup.academy.mauricio.casadocodigo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import br.com.zup.academy.mauricio.casadocodigo.validation.UniqueValue;

@Entity
@Table(name = "Autor")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	@Email
	
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	@Size(max = 400)
	private String descricao;

	private LocalDateTime dataDateTime = LocalDateTime.now();

	public Autor(@Email String nome, String email, String descricao) {
		super();
		this.email = email;
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}



	public String getEmail() {
		return email;
	}

	

	public String getDescricao() {
		return descricao;
	}



}
