package com.cruiseline.cruiseline.anotation;

import com.cruiseline.cruiseline.validator.NotEmptyArrivalOrDepartureDateTimeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotEmptyArrivalOrDepartureDateTimeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEmptyArrivalOrDepartureDateTime {
    String message() default "cruise.destinations.date.time.fullness";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
