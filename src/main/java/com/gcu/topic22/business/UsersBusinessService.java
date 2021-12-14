package com.gcu.topic22.business;

import com.gcu.topic22.data.UsersDataService;
import com.gcu.topic22.data.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersBusinessService implements UserDetailsService {

    @Autowired
    private UsersDataService usersDataService;

    public UsersBusinessService(UsersDataService usersDataService) {
        this.usersDataService = usersDataService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = usersDataService.findByUsername(username);
        if(user != null){
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            return new User(user.getUsername(), user.getPassword(), authorities);
        }else {
            throw new UsernameNotFoundException("Username not found");
        }
    }
}
