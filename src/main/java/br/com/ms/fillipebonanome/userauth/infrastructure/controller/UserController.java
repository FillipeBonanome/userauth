package br.com.ms.fillipebonanome.userauth.infrastructure.controller;

import br.com.ms.fillipebonanome.userauth.application.usecases.CreateUserImplementation;
import br.com.ms.fillipebonanome.userauth.domain.entities.User;
import br.com.ms.fillipebonanome.userauth.domain.enums.Role;
import br.com.ms.fillipebonanome.userauth.infrastructure.dto.CreateUserDTO;
import br.com.ms.fillipebonanome.userauth.infrastructure.dto.ReadUserDTO;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final CreateUserImplementation createUser;

    public UserController(CreateUserImplementation createUser) {
        this.createUser = createUser;
    }

    @PostMapping
    @Transactional
    public ReadUserDTO registerUser(@RequestBody @Valid CreateUserDTO userDTO) {
        User user = createUser.createUser(new User(
           userDTO.name(),
           userDTO.username(),
           userDTO.password(),
           userDTO.email(),
            Role.USER,
            List.of(),
            false
        ));
        return new ReadUserDTO(
                user.getUsername(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getPermissions()
        );
    }

}
