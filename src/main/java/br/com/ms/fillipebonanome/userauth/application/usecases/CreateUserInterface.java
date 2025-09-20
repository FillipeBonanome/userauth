package br.com.ms.fillipebonanome.userauth.application.usecases;

import br.com.ms.fillipebonanome.userauth.domain.entities.User;

public interface CreateUserInterface {
    public User createUser(User user);
}
