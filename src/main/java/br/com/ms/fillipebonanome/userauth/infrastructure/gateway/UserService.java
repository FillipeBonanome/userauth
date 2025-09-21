package br.com.ms.fillipebonanome.userauth.infrastructure.gateway;

import br.com.ms.fillipebonanome.userauth.application.gateway.UserRepositoryGateway;
import br.com.ms.fillipebonanome.userauth.domain.entities.User;
import br.com.ms.fillipebonanome.userauth.infrastructure.persistence.UserEntity;
import br.com.ms.fillipebonanome.userauth.infrastructure.persistence.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserService implements UserRepositoryGateway {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserEntityMapper userEntityMapper, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
        this.passwordEncoder = passwordEncoder;
    }

    //TODO --> Password...
    @Override
    public User registerUser(User user) {
        UserEntity userEntity = userEntityMapper.toEntity(user);
        userEntity.setEncodedPassword(passwordEncoder.encode(userEntity.getPassword()));
        System.out.println(userEntity.getPassword() + " hash password");
        userRepository.save(userEntity);
        return user;
    }

}
