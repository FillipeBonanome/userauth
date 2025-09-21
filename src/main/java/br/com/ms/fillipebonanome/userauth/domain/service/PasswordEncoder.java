package br.com.ms.fillipebonanome.userauth.domain.service;

public interface PasswordEncoder {
    String encode(String password);
    boolean matches(String password, String encodedPassword);
}
