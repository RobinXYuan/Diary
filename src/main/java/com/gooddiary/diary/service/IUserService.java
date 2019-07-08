package com.gooddiary.diary.service;

import com.gooddiary.diary.model.authority.User;

public interface IUserService {
    User createNewUserAccount(String email, String password);
    User getUserByEmail(String email);
}
