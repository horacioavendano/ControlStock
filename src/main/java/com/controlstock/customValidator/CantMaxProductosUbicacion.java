package com.controlstock.customValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CantMaxProductosUbicacionValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CantMaxProductosUbicacion {
	String message() default "Supero la cantidad máxima de productos distintos por ubicación. (3 productos)";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
