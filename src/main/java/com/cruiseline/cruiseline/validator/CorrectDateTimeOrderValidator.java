package com.cruiseline.cruiseline.validator;

import com.cruiseline.cruiseline.anotation.CorrectDateTimeOrder;
import com.cruiseline.cruiseline.entity.Destination;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.util.List;

public class CorrectDateTimeOrderValidator implements ConstraintValidator<CorrectDateTimeOrder, List<Destination>> {

    @Override
    public void initialize(CorrectDateTimeOrder constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Destination> destinations, ConstraintValidatorContext constraintValidatorContext) {
        LocalDateTime buffer = null;
        for (Destination destination : destinations) {
            LocalDateTime arrivalDateTime = destination.getArrivalDateTime();
            LocalDateTime departureDateTime = destination.getDepartureDateTime();
            if (arrivalDateTime != null) {
                if (buffer != null && (buffer.isAfter(arrivalDateTime) || buffer.isEqual(arrivalDateTime))) {
                    return false;
                }
                buffer = arrivalDateTime;
            }
            if (departureDateTime != null) {
                if (buffer != null && (buffer.isAfter(departureDateTime) || buffer.isEqual(departureDateTime))) {
                    return false;
                }
                buffer = departureDateTime;
            }
        }
        return true;
    }
}
