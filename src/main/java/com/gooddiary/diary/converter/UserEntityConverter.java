package com.gooddiary.diary.converter;

import com.gooddiary.diary.controller.request.NewUserRequest;
import com.gooddiary.diary.model.authority.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;


public class UserEntityConverter implements Converter<NewUserRequest, User> {

    @Nullable
    @Override
    public User convert(NewUserRequest source) {
        return User.builder()
                .email(source.getEmail())
                .password(source.getPassword())
                .build();
    }

}
