package thelameres.bv.validator.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import thelameres.bv.validator.constraint_validator.RussianPhoneValidator;

@Documented
@Constraint(validatedBy = RussianPhoneValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RussianPhone {

  String message() default "Номер должен быть в формате +7XXX... или 8XXX...";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}