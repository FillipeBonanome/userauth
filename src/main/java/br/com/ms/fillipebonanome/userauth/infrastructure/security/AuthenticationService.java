package br.com.ms.fillipebonanome.userauth.infrastructure.security;

import br.com.ms.fillipebonanome.userauth.domain.exceptions.UserException;
import br.com.ms.fillipebonanome.userauth.infrastructure.persistence.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UserException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UserException("User not found"));
    }
}
