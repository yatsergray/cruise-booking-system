package com.cruiseline.cruiseline.validator;

import com.cruiseline.cruiseline.anotation.NotEmptyArrivalOrDepartureDateTime;
import com.cruiseline.cruiseline.entity.Destination;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.util.List;

public class NotEmptyArrivalOrDepartureDateTimeValidator implements ConstraintValidator<NotEmptyArrivalOrDepartureDateTime, List<Destination>> {

    @Override
    public void initialize(NotEmptyArrivalOrDepartureDateTime constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Destination> destinations, ConstraintValidatorContext constraintValidatorContext) {
        for (int i = 0; i < destinations.size(); i++) {
            LocalDateTime arrivalDateTime = destinations.get(i).getArrivalDateTime();
            LocalDateTime departureDateTime = destinations.get(i).getDepartureDateTime();
            if (i != 0 && arrivalDateTime == null) {
                return false;
            }
            if (i != destinations.size() - 1 && departureDateTime == null) {
                return false;
            }
        }
        return true;
    }
}
