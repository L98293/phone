package com.l98293.phone;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * <p>This annotation allows you to select a region based on the <b>ISO 3166-1</b> international standard
 * and validates the phone number format for each specific region.</p>
 * <p>It returns <b>true</b> if the phone number is {@code null}.
 * To prevent null or empty values, it should be used in conjunction with other annotations such as {@code @NotEmpty} or {@code @NotBlank}.</p>
 * @version 1.0
 * @author L98293
 */

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {

	String message() default "Invalid phone number format.";

	Region region() ;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}