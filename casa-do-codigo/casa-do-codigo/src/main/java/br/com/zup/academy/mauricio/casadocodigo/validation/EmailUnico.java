package br.com.zup.academy.mauricio.casadocodigo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidation.class )
public @interface EmailUnico {
	String message() default "Error : the email already exist!";
	Class<?>[] groups() default{};
	public abstract Class<? extends Payload>[] payload() default{};
}
