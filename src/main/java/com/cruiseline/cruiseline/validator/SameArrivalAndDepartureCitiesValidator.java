package com.cruiseline.cruiseline.validator;

import com.cruiseline.cruiseline.anotation.SameArrivalAndDepartureCities;
import com.cruiseline.cruiseline.entity.Destination;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class SameArrivalAndDepartureCitiesValidator implements ConstraintValidator<SameArrivalAndDepartureCities, List<Destination>> {

    @Override
    public void initialize(SameArrivalAndDepartureCities constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Destination> destinations, ConstraintValidatorContext constraintValidatorContext) {
        return destinations.get(0).getCity().getId().equals(destinations.get(destinations.size() - 1).getCity().getId());
    }
}
