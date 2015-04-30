package com.levelup.spring.service.impl;

import com.levelup.spring.dao.UserRepository;
import com.levelup.spring.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denis_zavadsky on 4/30/15.
 */
@Component("customUserDetailService")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.getUserByLogin(s);
        WebUser webUser = new WebUser();
        webUser.setUser(user);
        webUser.setUsername(user.getLogin());
        webUser.setPassword(user.getPassword());
        webUser.setEnabled(true);
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);
        webUser.setAuthorities(authorities);
        return webUser;
    }
}
