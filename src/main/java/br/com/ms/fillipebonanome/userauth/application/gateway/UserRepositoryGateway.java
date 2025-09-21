package br.com.ms.fillipebonanome.userauth.application.gateway;

import br.com.ms.fillipebonanome.userauth.domain.entities.User;

import java.util.List;
import java.util.UUID;

/*
    Possui a assinatura dos métodos que seriam encontrados em um Service
*/
public interface UserRepositoryGateway {
    User registerUser(User user);
}
