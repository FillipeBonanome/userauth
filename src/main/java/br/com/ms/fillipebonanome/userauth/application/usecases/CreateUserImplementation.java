package br.com.ms.fillipebonanome.userauth.application.usecases;

import br.com.ms.fillipebonanome.userauth.application.gateway.UserRepositoryGateway;
import br.com.ms.fillipebonanome.userauth.domain.entities.User;

public class CreateUserImplementation implements CreateUserInterface {

    private final UserRepositoryGateway userRepositoryGateway;

    public CreateUserImplementation(UserRepositoryGateway userRepositoryGateway) {
        this.userRepositoryGateway = userRepositoryGateway;
    }

    @Override
    public User createUser(User user) {
        return userRepositoryGateway.registerUser(user);
    }
}
