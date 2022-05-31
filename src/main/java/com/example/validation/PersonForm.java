package com.example.validation;
import javax.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
public class PersonForm {

    @NotNull(message = "Name must not be null.")
    @Size(min=2, max=30, message = "Name must be between 2 and 30 characters, inclusive.")
    private String name;

    @NotNull(message = "Age must not be null.")
    @Min(value = 18, message = "Age must be 18 or older.")
    private Integer age;

    @Pattern(regexp = "(?:red|yellow|green|off)", message = "Color must be: \"red\", \"yellow\", \"green\", or \"off\".")
    private String color;

    @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$", message = "Please enter a valid phone number.")
    private String phoneNumber;
}
