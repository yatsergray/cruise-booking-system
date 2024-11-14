package com.cruiseline.cruiseline.validator;

import com.cruiseline.cruiseline.anotation.SufficientTimeBetweenDestinations;
import com.cruiseline.cruiseline.entity.Destination;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.util.List;

public class SufficientTimeBetweenDestinationsValidator implements ConstraintValidator<SufficientTimeBetweenDestinations, List<Destination>> {

    @Override
    public void initialize(SufficientTimeBetweenDestinations constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Destination> destinations, ConstraintValidatorContext constraintValidatorContext) {
        LocalDateTime buffer = null;
        for (Destination destination : destinations) {
            LocalDateTime arrivalDateTime = destination.getArrivalDateTime();
            LocalDateTime departureDateTime = destination.getDepartureDateTime();
            if (arrivalDateTime != null) {
                if (buffer != null && buffer.isAfter(arrivalDateTime.minusHours(9))) {
                    return false;
                }
                buffer = arrivalDateTime;
            }
            if (departureDateTime != null) {
                if (buffer != null && buffer.isAfter(departureDateTime.minusHours(9))) {
                    return false;
                }
                buffer = departureDateTime;
            }
        }
        return true;
    }
}
