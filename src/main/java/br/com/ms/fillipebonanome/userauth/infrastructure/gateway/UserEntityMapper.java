package br.com.ms.fillipebonanome.userauth.infrastructure.gateway;

import br.com.ms.fillipebonanome.userauth.domain.entities.User;
import br.com.ms.fillipebonanome.userauth.infrastructure.persistence.UserEntity;

public class UserEntityMapper {

    public UserEntity toEntity(User user) {
        return new UserEntity(
                user.getName(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getRole(),
                user.getPermissions(),
                user.getDeleted()
        );
    }

    public User toDomain(UserEntity userEntity) {
        return new User(
                userEntity.getName(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getRole(),
                userEntity.getPermissions(),
                userEntity.getDeleted()
        );
    }

}
