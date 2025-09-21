package br.com.ms.fillipebonanome.userauth.infrastructure.controller;

import br.com.ms.fillipebonanome.userauth.application.usecases.CreateUserImplementation;
import br.com.ms.fillipebonanome.userauth.domain.entities.User;
import br.com.ms.fillipebonanome.userauth.domain.enums.Role;
import br.com.ms.fillipebonanome.userauth.infrastructure.dto.CreateUserDTO;
import br.com.ms.fillipebonanome.userauth.infrastructure.dto.LoginDTO;
import br.com.ms.fillipebonanome.userauth.infrastructure.dto.ReadUserDTO;
import br.com.ms.fillipebonanome.userauth.infrastructure.dto.TokenDTO;
import br.com.ms.fillipebonanome.userauth.infrastructure.gateway.UserEntityMapper;
import br.com.ms.fillipebonanome.userauth.infrastructure.persistence.UserEntity;
import br.com.ms.fillipebonanome.userauth.infrastructure.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final CreateUserImplementation createUser;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserEntityMapper userEntityMapper;

    public UserController(CreateUserImplementation createUser, AuthenticationManager authenticationManager, TokenService tokenService, UserEntityMapper userEntityMapper) {
        this.createUser = createUser;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.userEntityMapper = userEntityMapper;
    }

    @PostMapping("/sign-up")
    @Transactional
    public ResponseEntity<ReadUserDTO> registerUser(@RequestBody @Valid CreateUserDTO userDTO, UriComponentsBuilder uriBuilder) {
        User user = createUser.createUser(new User(
           userDTO.name(),
           userDTO.username(),
           userDTO.password(),
           userDTO.email(),
            Role.USER,
            List.of(),
            false
        ));
        ReadUserDTO readUserDTO = new ReadUserDTO(
                user.getUsername(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getPermissions()
        );
        return  ResponseEntity.created(uriBuilder.path("/api/users/{id}").buildAndExpand(user.getId()).toUri()).body(readUserDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> loginUser(@RequestBody @Valid LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginDTO.username(), loginDTO.password());
        Authentication authentication = authenticationManager.authenticate(token);
        UserEntity userEntity = (UserEntity) authentication.getPrincipal();
        String tokenJWT = tokenService.generateToken(userEntityMapper.toDomain(userEntity));
        return ResponseEntity.ok(new TokenDTO(tokenJWT));
    }

}
