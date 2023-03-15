package com.music.music.services;

import com.music.music.domain.User;
import com.music.music.exceptions.AlreadyExistsException;
import com.music.music.exceptions.NotFoundException;
import com.music.music.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
//public class UserService implements UserDetailsService {
public class UserService{

    final UserRepository userRepository;
    //private final BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User user = findUserByUsername(username);
//        if (user == null)
//            throw new UsernameNotFoundException(String.format("User: %s does not exist", username));
//        return user;
//    }

    public User findUserByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    public User findUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User ID: %s does not exist", id)));
    }

    public User saveUser(User user) {

        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new AlreadyExistsException(String.format("Username: %s already exists", user.getUsername()));
        }
    }
}
