package igc.tech.com.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationController implements AuthenticationProvider{
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("ssssss");

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        System.out.println(name);
        System.out.println(password);

        if (name == null || password == null) {
            throw new BadCredentialsException("Invalid Login Credentials");
        }

        if (name.equals("sajan") && password.equals("abcd")) {
            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
            Authentication auth = new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
            return auth;
        } else {
            throw new BadCredentialsException("Invalid Login Credentials");
        }


    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
