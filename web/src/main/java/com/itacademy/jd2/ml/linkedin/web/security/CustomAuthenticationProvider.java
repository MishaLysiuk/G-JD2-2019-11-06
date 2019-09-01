package com.itacademy.jd2.ml.linkedin.web.security;

import java.util.ArrayList;
import java.util.List;

import com.itacademy.jd2.ml.linkedin.IUserAccountService;
import com.itacademy.jd2.ml.linkedin.entity.enums.Role;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private IUserAccountService userAccountService;

    @Autowired
    public CustomAuthenticationProvider(IUserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public Authentication authenticate(final Authentication authentication)
            throws AuthenticationException {

        final String email = authentication.getPrincipal() + "";
        final String password = authentication.getCredentials() + "";


        IUserAccount byEmail = userAccountService.findByEmail(email);
        if (byEmail == null) {
            throw new BadCredentialsException("1000");
        }

        if (!byEmail.getPassword().equals(password)) {
            throw new BadCredentialsException("1000");
        }

        final int userId = byEmail.getId();

        List<String> userRoles = new ArrayList<>();// TODO get list of user's
        // roles
        Role role = byEmail.getRole();


        final List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.name()));

        ExtendedToken token = new ExtendedToken(email, password, authorities);
        token.setId(userId);
        return token;

    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}