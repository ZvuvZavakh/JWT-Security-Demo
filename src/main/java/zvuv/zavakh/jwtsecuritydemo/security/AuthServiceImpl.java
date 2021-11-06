package zvuv.zavakh.jwtsecuritydemo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import zvuv.zavakh.jwtsecuritydemo.domain.User;
import zvuv.zavakh.jwtsecuritydemo.web.dto.AuthDto;
import zvuv.zavakh.jwtsecuritydemo.web.dto.UserDto;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {

    @Value("${secretKey}")
    private String secretKey;

    @Value("${expirationDaysCount}")
    private int expirationDaysCount;

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public ResponseEntity<UserDto> login(AuthDto authDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authDto.getEmail(), authDto.getPassword())
        );

        User user = (User) authentication.getPrincipal();
        UserDto userDto = UserDto
                .builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .isVerified(user.isVerified())
                .isEnabled(user.isEnabled())
                .build();
        String token = Jwts.builder()
                .setIssuer(user.getEmail())
                .claim("user", userDto)
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(expirationDaysCount)))
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8)))
                .compact();
        String header = "Bearer " + token;

        //TODO MAP USER TO USER DTO
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, header)
                .body(userDto);
    }
}
