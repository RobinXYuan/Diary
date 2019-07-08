package com.gooddiary.diary.repository.authority;

import com.gooddiary.diary.model.authority.Role;
import com.gooddiary.diary.model.authority.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    List<User> findByFirstName(String firstName);
    List<User> findByRole(Role role);

}
