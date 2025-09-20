package br.com.ms.fillipebonanome.userauth.infrastructure.dto;

import br.com.ms.fillipebonanome.userauth.domain.enums.Permission;
import br.com.ms.fillipebonanome.userauth.domain.enums.Role;

import java.util.List;

public record ReadUserDTO(
        String username,
        String name,
        String email,
        Role role,
        List<Permission> permissions
) {
}
