package zvuv.zavakh.jwtsecuritydemo.services;

import zvuv.zavakh.jwtsecuritydemo.domain.User;
import zvuv.zavakh.jwtsecuritydemo.web.dto.UserDto;

import java.util.UUID;

public interface UserService {

    User getUserByEmail(String email);
    UserDto getById(UUID id);
    UserDto create(UserDto userDto);
    UserDto update(UserDto userDto, UUID id);
    UserDto delete(UUID id);
    void verifyUser(UUID id);
    void setUserEnabled(UUID id, Boolean isEnabled);
}
