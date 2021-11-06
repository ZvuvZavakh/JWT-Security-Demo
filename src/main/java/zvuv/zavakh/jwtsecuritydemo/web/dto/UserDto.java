package zvuv.zavakh.jwtsecuritydemo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class UserDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean isVerified;
    private Boolean isEnabled;
}
