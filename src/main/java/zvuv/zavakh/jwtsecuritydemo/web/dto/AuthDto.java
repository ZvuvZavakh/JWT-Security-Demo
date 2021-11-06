package zvuv.zavakh.jwtsecuritydemo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AuthDto {

    private String email;
    private String password;
}
