package engine.security;

import engine.persistence.model.User;
import engine.persistence.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class EngineUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public EngineUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userService.get(email);
        return new UserPrincipal(user);
    }
}