package br.com.ms.fillipebonanome.userauth.domain.service;

import br.com.ms.fillipebonanome.userauth.domain.entities.User;

public interface TokenGeneratorInterface {
    String generateToken(User user);
    String getSubject(String token);
}
