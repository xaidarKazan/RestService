package ru.practic.first.sbsWEB.security;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.practic.first.sbsWEB.entity.User;
import java.util.Collection;

@Data
@RequiredArgsConstructor
public class UserSecurity implements UserDetails {

    private final String name;
    private final String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public static UserDetails toUserDetails(User user) {
        return org.springframework.security.core.userdetails.User
                  .builder()
                    .username(user.getLogin())
                    .password(user.getPassword())
                    .roles("USER")
                  .build();
    }
}