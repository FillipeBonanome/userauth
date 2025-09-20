package br.com.ms.fillipebonanome.userauth.infrastructure.gateway;

import br.com.ms.fillipebonanome.userauth.application.gateway.UserRepositoryGateway;
import br.com.ms.fillipebonanome.userauth.domain.entities.User;
import br.com.ms.fillipebonanome.userauth.infrastructure.persistence.UserEntity;
import br.com.ms.fillipebonanome.userauth.infrastructure.persistence.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.UUID;

public class UserService implements UserRepositoryGateway {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserEntityMapper userEntityMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
        this.passwordEncoder = passwordEncoder;
    }
    //TODO --> Password...
    @Override
    public User registerUser(User user) {
        UserEntity userEntity = userEntityMapper.toEntity(user);
        userEntity.setEncodedPassword(passwordEncoder.encode(userEntity.getPassword()));
        UserEntity savedUserEntity = userRepository.save(userEntity);
        savedUserEntity.setPassword(user.getPassword());
        return userEntityMapper.toDomain(savedUserEntity);
    }

    @Override
    public List<User> readUsers() {
        return List.of();
    }

    @Override
    public User readUserFromId(UUID uuid) {
        return null;
    }
}
