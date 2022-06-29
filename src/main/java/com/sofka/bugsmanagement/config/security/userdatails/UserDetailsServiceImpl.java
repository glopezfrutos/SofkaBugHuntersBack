package com.sofka.bugsmanagement.config.security.userdatails;

import com.sofka.bugsmanagement.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
@Service
public class UserDetailsServiceImpl implements ReactiveUserDetailsService {
    @Autowired
    IUserRepository userRepository;


    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userRepository.getUserByEmail(username).map(userMono -> new MyUserDetails(userMono));
    }
}
