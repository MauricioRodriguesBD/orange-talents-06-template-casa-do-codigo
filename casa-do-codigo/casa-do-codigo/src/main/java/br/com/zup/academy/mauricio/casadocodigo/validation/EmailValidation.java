package br.com.zup.academy.mauricio.casadocodigo.validation;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;



import br.com.zup.academy.mauricio.casadocodigo.model.Autor;
import br.com.zup.academy.mauricio.casadocodigo.repository.AutorRepository;

public class EmailValidation implements ConstraintValidator<EmailUnico, String>{
	
	@Autowired
	private AutorRepository repository;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Optional<Autor> autor = repository.findByEmail(value);
		if (autor.isPresent()) {
			return false;
		}
		return true;
		
	}
	
	@Override
	public void initialize(EmailUnico constraintEmailNaoNulo) {
		ConstraintValidator.super.initialize(constraintEmailNaoNulo);
	}

	
	
	
}
