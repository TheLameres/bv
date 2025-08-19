package thelameres.bv.validator.constraint_validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;
import thelameres.bv.validator.annotation.RussianPhone;

public class RussianPhoneValidator implements ConstraintValidator<RussianPhone, String> {

  private static final Pattern PATTERN =
      Pattern.compile("^(\\+7|8)\\d{10}$");

  @Override
  public void initialize(RussianPhone constraintAnnotation) {
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null) {return true;}

    var cleaned = value.replaceAll("[\\s\\-()]", "");
    return PATTERN.matcher(cleaned).matches();
  }
}