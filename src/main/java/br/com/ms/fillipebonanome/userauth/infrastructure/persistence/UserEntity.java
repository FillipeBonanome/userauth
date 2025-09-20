package br.com.ms.fillipebonanome.userauth.infrastructure.persistence;

import br.com.ms.fillipebonanome.userauth.domain.enums.Permission;
import br.com.ms.fillipebonanome.userauth.domain.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "users")
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank @Email
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    /*
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_permission",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )*/
    @Transient
    private List<Permission> permissions;
    private Boolean deleted;

    public UserEntity() {
    }

    public UserEntity(String name, String username, String password, String email, Role role, List<Permission> permissions, Boolean deleted) {
        setName(name);
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setRole(role);
        setPermissions(permissions);
        setDeleted(deleted);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public void setUsername(@NotBlank String username) {
        this.username = username;
    }

    public void setPassword(@NotBlank String password) {
        this.password = password;
    }

    public @NotBlank @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email String email) {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        this.getPermissions().forEach(permission -> {
            authorities.add(new SimpleGrantedAuthority(permission.name()));
        });
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.name()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setEncodedPassword(String password) {
        this.password = password;
    }
}
