package com.controlstock.customValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = EnDepositoValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EnDeposito {
	String message() default "El Producto no está en el depósito";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
