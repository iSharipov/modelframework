package io.github.isharipov.modelframework;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public abstract class ModelConstraintValidator<A extends Annotation, I extends Model> implements ConstraintValidator<A, String> {
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        try {
            instance(value);
            return true;
        } catch (ValidationException ex) {
            return false;
        }
    }

    protected abstract void instance(String value);
}
