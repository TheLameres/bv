package thelameres.bv.dto;

import jakarta.validation.constraints.NotNull;
import thelameres.bv.validator.annotation.RussianPhone;

public record SignupDto(
    @NotNull
    String name,
    @RussianPhone
    String homePhone,
    @RussianPhone
    @NotNull
    String mobilePhone
) {

}
