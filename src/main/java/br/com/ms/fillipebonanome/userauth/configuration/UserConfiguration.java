package br.com.ms.fillipebonanome.userauth.configuration;

import br.com.ms.fillipebonanome.userauth.application.gateway.UserRepositoryGateway;
import br.com.ms.fillipebonanome.userauth.application.usecases.CreateUserImplementation;
import br.com.ms.fillipebonanome.userauth.infrastructure.gateway.UserEntityMapper;
import br.com.ms.fillipebonanome.userauth.infrastructure.gateway.UserService;
import br.com.ms.fillipebonanome.userauth.infrastructure.persistence.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration {

    @Bean
    CreateUserImplementation createUserImplementation(UserService userService) {
        return new CreateUserImplementation(userService);
    }

    @Bean
    UserService userService(UserRepository userRepository, UserEntityMapper userEntityMapper, PasswordEncoder passwordEncoder) {
        return new UserService(userRepository, userEntityMapper, passwordEncoder);
    }

    @Bean
    UserEntityMapper userEntityMapper() {
        return new UserEntityMapper();
    }

    @Bean
    UserRepositoryGateway userRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper, PasswordEncoder passwordEncoder) {
        return new UserService(userRepository, userEntityMapper, passwordEncoder);
    }

}
