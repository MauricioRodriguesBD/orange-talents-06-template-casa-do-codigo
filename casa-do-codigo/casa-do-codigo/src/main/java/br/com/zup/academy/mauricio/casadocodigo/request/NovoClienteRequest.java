package br.com.zup.academy.mauricio.casadocodigo.request;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import br.com.zup.academy.mauricio.casadocodigo.model.Autor;
import br.com.zup.academy.mauricio.casadocodigo.model.Cliente;
import br.com.zup.academy.mauricio.casadocodigo.model.Estado;
import br.com.zup.academy.mauricio.casadocodigo.model.Pais;
import br.com.zup.academy.mauricio.casadocodigo.validation.ExistsId;
import br.com.zup.academy.mauricio.casadocodigo.validation.UniqueValue;

public class NovoClienteRequest {

	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobreNome;

	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;
	
	@NotBlank
	private String cidade;
	
	
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	
	private Long idEstado;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String cep;

	public NovoClienteRequest(@Email String email, @NotBlank String nome, @NotBlank String sobreNome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank Long idPais, Long idEstado, @NotBlank String telefone,
			@NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Cliente toModel(EntityManager manager) {
		@NotNull
		Pais pais = manager.find(Pais.class,idPais);
		@NotNull
		Estado estado = manager.find(Estado.class,idEstado);
		
		Assert.state(pais != null, "Não é possível cadastrar pois o pais não se encontra no banco" + idPais);
		Assert.state(estado != null, "Não é possível cadastrar pois o estado não se encontra no banco" + idEstado);

		return new Cliente(this.email,this.nome,this.sobreNome,this.documento,
				this.endereco,this.complemento,this.cidade,pais,estado,
				this.telefone,this.cep);
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}
	
	
	
	
}
