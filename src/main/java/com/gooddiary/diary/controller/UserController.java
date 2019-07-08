package com.gooddiary.diary.controller;

import com.gooddiary.diary.controller.request.NewUserRequest;
import com.gooddiary.diary.model.authority.User;
import com.gooddiary.diary.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;


@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public User register(@Valid @RequestBody NewUserRequest newUserRequest, BindingResult result) {

        User user = new User(newUserRequest.getEmail());

        if (userService.exists(user)) {
            throw new UserAlreadyExistsException(result);
        }

        user.setPassword(newUserRequest.getPassword());

        return userService.createNewUserAccount(newUserRequest.getEmail(), newUserRequest.getPassword());

    }

}
