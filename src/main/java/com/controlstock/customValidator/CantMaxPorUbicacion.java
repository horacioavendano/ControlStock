package com.controlstock.customValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CantMaxPorUbicacionValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CantMaxPorUbicacion {
	String message() default "Supero la cantidad máxima de productos por ubicación. (100 unidades)";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
