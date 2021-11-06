package zvuv.zavakh.jwtsecuritydemo.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zvuv.zavakh.jwtsecuritydemo.security.AuthService;
import zvuv.zavakh.jwtsecuritydemo.web.dto.AuthDto;
import zvuv.zavakh.jwtsecuritydemo.web.dto.UserDto;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody AuthDto authDto) {
        return authService.login(authDto);
    }
}
