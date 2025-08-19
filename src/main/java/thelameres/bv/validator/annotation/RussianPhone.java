@java.lang.annotation.Documented
@jakarta.validation.Constraint(validatedBy = thelameres.bv.RussianPhoneValidator.class)
@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface RussianPhone {
    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends jakarta.validation.Payload>[] payload() default {};
}