package com.cruiseline.cruiseline.anotation;

import com.cruiseline.cruiseline.validator.SameArrivalAndDepartureCitiesValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SameArrivalAndDepartureCitiesValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SameArrivalAndDepartureCities {
    String message() default "cruise.destinations.arrival.departure.cities";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
