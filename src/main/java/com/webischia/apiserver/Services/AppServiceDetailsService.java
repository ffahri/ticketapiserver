package com.webischia.apiserver.Services;

import com.webischia.apiserver.Domains.AccessLevel;
import com.webischia.apiserver.Domains.User;
import com.webischia.apiserver.Repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppServiceDetailsService implements UserDetailsService{

    private final UserRepository userRepository;

    public AppServiceDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s).get();

        if(user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
   /*     user.getAccessLevel().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });*/
        AccessLevel accessLevel = user.getAccessLevel();
        authorities.add(new SimpleGrantedAuthority(accessLevel.getDescription()));

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getUsername(), user.getPassword(), authorities);

        return userDetails;

    }
}
