package vn.tuananh.userdemo.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUser {
    @NotNull(message = "Full name is required")
    @NotEmpty(message = "Full name is required")
    private String name;
    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email is required")
    @Email(message = "Please provide a valid email")
    private String email;
    @Pattern(regexp = "(09|01[2|6|8|9])+([0-9]{8})\\b", message = "Please provide a valid phone number")
    private String phone;

    @NotNull(message = "Address is required")
    @NotEmpty(message = "Address is required")
    private String address;
    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password is required")
    private String password;
}
