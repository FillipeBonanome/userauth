package br.com.ms.fillipebonanome.userauth.domain.entities;

import br.com.ms.fillipebonanome.userauth.domain.enums.Permission;
import br.com.ms.fillipebonanome.userauth.domain.enums.Role;
import br.com.ms.fillipebonanome.userauth.domain.exceptions.UserException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String username;
    private String password;
    private String email;
    private Role role;
    private List<Permission> permissions = new ArrayList<>();
    private Boolean deleted;

    //TODO --> Change because of hashing
    public User(String name, String username, String password, String email, Role role, List<Permission> permissions, Boolean deleted) {
        setName(name);
        setUsername(username);
        this.password = password;
        setEmail(email);
        setRole(role);
        setPermissions(permissions);
        setDeleted(deleted);
    }

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        if(id == null) {
            throw new UserException("User id must not be null");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null) {
            throw new UserException("User name must not be null");
        }
        if(name.isBlank()) {
            throw new UserException("User name must not be blank");
        }
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username == null) {
            throw new UserException("Username must not be null");
        }
        if(username.isBlank()) {
            throw new UserException("Username must not be blank");
        }
        if(!username.matches("^(?=.*[a-zA-Z])(?=.*\\d).{6,}$")) {
            throw new UserException("Username must have at least 6 digits, letters and numbers");
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    //TODO --> Change REGEX
    public void setPassword(String password) {
        if(password == null) {
            throw new UserException("User password cannot be null");
        }
        if(password.isBlank()) {
            throw new UserException("User password cannot be blank");
        }
        if(!password.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&_#])[A-Za-z\\d@$!%*?&_#]{8,}$")) {
            throw new UserException("User password must have at least 8 digits, numbers and special characters");
        }
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new UserException("User email is not valid");
        }
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
