package com.htn.security.custom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.htn.entity.Role;
import com.htn.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
public class CustomUserDetails implements UserDetails {
	@Serial
	private static final long serialVersionUID = 1L;

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

	public static CustomUserDetails build(User user) {
        return new CustomUserDetails(user);
	}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles = user.getRoles();

        if (roles == null || roles.isEmpty()) {
            return List.of();
        }

        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleCode()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        // login bằng email
        return user.getEmail();
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return user.getPassword();
    }

	@Override
	public boolean isAccountNonExpired() {
        //account hết hạn -> AccountExpiredException
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
        // account bị khóa -> LockedException
        return "Y".equalsIgnoreCase(user.getUsedYn());
	}

	@Override
	public boolean isCredentialsNonExpired() {
        //password hết hạn > CredentialsExpiredException
		return true;
	}

	@Override
	public boolean isEnabled() {
        // account chưa kích hoạt -> DisabledException
        return "Y".equalsIgnoreCase(user.getVerifyYn());
	}
}
