package zvuv.zavakh.jwtsecuritydemo.security;

import org.springframework.http.ResponseEntity;
import zvuv.zavakh.jwtsecuritydemo.web.dto.AuthDto;
import zvuv.zavakh.jwtsecuritydemo.web.dto.UserDto;

public interface AuthService {

    ResponseEntity<UserDto> login(AuthDto authDto);
}
