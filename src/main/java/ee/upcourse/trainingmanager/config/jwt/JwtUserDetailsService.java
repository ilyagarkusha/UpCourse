package ee.upcourse.trainingmanager.config.jwt;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import ee.upcourse.trainingmanager.model.Role;
import ee.upcourse.trainingmanager.model.User;
import ee.upcourse.trainingmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user==null) throw new UsernameNotFoundException("User not found");

        JwtUser jwtUser = JwtUserFactory.create(user);
        return jwtUser;
    }
}
