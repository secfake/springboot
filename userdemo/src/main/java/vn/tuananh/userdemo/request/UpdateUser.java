package vn.tuananh.userdemo.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUser {
    @NotNull(message = "Full name is required")
    @NotEmpty(message = "Full name is required")
    private String name;

    @Pattern(regexp = "(09|01[2|6|8|9])+([0-9]{8})\\b", message = "Please provide a valid phone number")
    private String phone;

    @NotNull(message = "Address is required")
    @NotEmpty(message = "Address is required")
    private String address;

}

