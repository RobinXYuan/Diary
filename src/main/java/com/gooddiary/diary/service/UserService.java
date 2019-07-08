package com.gooddiary.diary.service;

import com.gooddiary.diary.model.authority.User;
import com.gooddiary.diary.repository.authority.RoleRepository;
import com.gooddiary.diary.repository.authority.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService implements IUserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User createNewUserAccount(String email, String password) {

        User user = User.builder()
                .email(email)
                .password(password)
                .role(roleRepository.findByName("ROLE_USER"))
                .build();

        return user;
    }

    @Override
    public User getUserByEmail(String email) {

        Optional<User> userOptional = userRepository.findByEmail(email);

        if (!userOptional.isPresent()) {
            return null;
        }

        return userOptional.get();
    }

    public boolean exists(User user) {
        return userRepository.findByEmail(user.getEmail()).isPresent();
    }

}
