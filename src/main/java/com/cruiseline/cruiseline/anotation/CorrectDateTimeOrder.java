package com.cruiseline.cruiseline.anotation;

import com.cruiseline.cruiseline.validator.CorrectDateTimeOrderValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CorrectDateTimeOrderValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CorrectDateTimeOrder {
    String message() default "cruise.destinations.date.time.order";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
