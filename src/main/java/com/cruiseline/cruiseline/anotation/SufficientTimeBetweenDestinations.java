package com.cruiseline.cruiseline.anotation;

import com.cruiseline.cruiseline.validator.SufficientTimeBetweenDestinationsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SufficientTimeBetweenDestinationsValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SufficientTimeBetweenDestinations {
    String message() default "cruise.destinations.date.time.interval";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
