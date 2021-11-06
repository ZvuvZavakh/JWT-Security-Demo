package zvuv.zavakh.jwtsecuritydemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import zvuv.zavakh.jwtsecuritydemo.domain.User;
import zvuv.zavakh.jwtsecuritydemo.repositories.UserRepository;
import zvuv.zavakh.jwtsecuritydemo.web.dto.UserDto;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", email)));
    }

    @Override
    public UserDto getById(UUID id) {
        return null;
    }

    @Override
    public UserDto create(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto update(UserDto userDto, UUID id) {
        return null;
    }

    @Override
    public UserDto delete(UUID id) {
        return null;
    }

    @Override
    public void verifyUser(UUID id) {

    }

    @Override
    public void setUserEnabled(UUID id, Boolean isEnabled) {

    }
}
